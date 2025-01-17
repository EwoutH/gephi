/*
 Copyright 2008-2013 Gephi
 Authors : Mathieu Bastian <mathieu.bastian@gephi.org>
 Website : http://www.gephi.org

 This file is part of Gephi.

 DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

 Copyright 2013 Gephi Consortium. All rights reserved.

 The contents of this file are subject to the terms of either the GNU
 General Public License Version 3 only ("GPL") or the Common
 Development and Distribution License("CDDL") (collectively, the
 "License"). You may not use this file except in compliance with the
 License. You can obtain a copy of the License at
 http://gephi.org/about/legal/license-notice/
 or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
 specific language governing permissions and limitations under the
 License.  When distributing the software, include this License Header
 Notice in each file and include the License files at
 /cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
 License Header, with the fields enclosed by brackets [] replaced by
 your own identifying information:
 "Portions Copyrighted [year] [name of copyright owner]"

 If you wish your version of this file to be governed by only the CDDL
 or only the GPL Version 3, indicate your decision by adding
 "[Contributor] elects to include this software in this distribution
 under the [CDDL or GPL Version 3] license." If you do not indicate a
 single choice of license, a recipient has the option to distribute
 your version of this file under either the CDDL, the GPL Version 3 or
 to extend the choice of license to its licensees as provided above.
 However, if you add GPL Version 3 code and therefore, elected the GPL
 Version 3 license, then the option applies only if the new code is
 made subject to such option by the copyright holder.

 Contributor(s):

 Portions Copyrighted 2013 Gephi Consortium.
 */

package org.gephi.appearance.plugin;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import org.gephi.appearance.api.Interpolator;
import org.gephi.appearance.api.Ranking;
import org.gephi.appearance.spi.RankingTransformer;
import org.gephi.appearance.spi.Transformer;
import org.gephi.graph.api.Element;
import org.openide.util.lookup.ServiceProvider;

/**
 * @author mbastian
 */
@ServiceProvider(service = Transformer.class)
public class RankingElementColorTransformer implements RankingTransformer<Element> {

    protected final LinearGradient linearGradient =
        new LinearGradient(new Color[] {new Color(0xEDF8FB), new Color(0x66C2A4), new Color(0x006D2C)},
            new float[] {0f, 0.5f, 1f});

    @Override
    public void transform(Element element, Ranking ranking, Interpolator interpolator, Number value) {
        Color color = linearGradient.getValue(ranking.normalize(value, interpolator));
        element.setColor(color);
    }

    @Override
    public boolean isNode() {
        return true;
    }

    @Override
    public boolean isEdge() {
        return true;
    }

    public float[] getColorPositions() {
        return linearGradient.getPositions();
    }

    public void setColorPositions(float[] positions) {
        linearGradient.setPositions(positions);
    }

    public Color[] getColors() {
        return linearGradient.getColors();
    }

    public void setColors(Color[] colors) {
        linearGradient.setColors(colors);
    }

    public LinearGradient getLinearGradient() {
        return linearGradient;
    }

    public static class LinearGradient implements Serializable, Cloneable {

        private Color[] colors;
        private float[] positions;

        public LinearGradient(Color colors[], float[] positions) {
            if (colors == null || positions == null) {
                throw new NullPointerException();
            }
            if (colors.length != positions.length) {
                throw new IllegalArgumentException();
            }
            this.colors = colors;
            this.positions = positions;
        }

        public Color getValue(float pos) {
            for (int a = 0; a < positions.length - 1; a++) {
                if (positions[a] == pos) {
                    return colors[a];
                }
                if (positions[a] < pos && pos < positions[a + 1]) {
                    float v = (pos - positions[a]) / (positions[a + 1] - positions[a]);
                    return tween(colors[a], colors[a + 1], v);
                }
            }
            if (pos <= positions[0]) {
                return colors[0];
            }
            if (pos >= positions[positions.length - 1]) {
                return colors[colors.length - 1];
            }
            return null;
        }

        private Color tween(Color c1, Color c2, float p) {
            return new Color(
                (int) (c1.getRed() * (1 - p) + c2.getRed() * (p)),
                (int) (c1.getGreen() * (1 - p) + c2.getGreen() * (p)),
                (int) (c1.getBlue() * (1 - p) + c2.getBlue() * (p)),
                (int) (c1.getAlpha() * (1 - p) + c2.getAlpha() * (p)));
        }

        public Color[] getColors() {
            return colors;
        }

        public void setColors(Color[] colors) {
            this.colors = colors;
        }

        public float[] getPositions() {
            return positions;
        }

        public void setPositions(float[] positions) {
            this.positions = positions;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final LinearGradient other = (LinearGradient) obj;
            if (!Arrays.deepEquals(this.colors, other.colors)) {
                return false;
            }
            if (!Arrays.equals(this.positions, other.positions)) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 17 * hash + Arrays.deepHashCode(this.colors);
            hash = 17 * hash + Arrays.hashCode(this.positions);
            return hash;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            LinearGradient cl = new LinearGradient(colors, positions);
            return cl;
        }
    }
}
