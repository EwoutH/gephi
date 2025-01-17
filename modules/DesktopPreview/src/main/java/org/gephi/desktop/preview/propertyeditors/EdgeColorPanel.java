/*
Copyright 2008-2010 Gephi
Authors : Jeremy Subtil <jeremy.subtil@gephi.org>
Website : http://www.gephi.org

This file is part of Gephi.

DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2011 Gephi Consortium. All rights reserved.

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

Portions Copyrighted 2011 Gephi Consortium.
 */

package org.gephi.desktop.preview.propertyeditors;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.gephi.preview.types.EdgeColor;
import org.gephi.ui.components.JColorButton;

/**
 * @author Mathieu Bastian
 */
public class EdgeColorPanel extends javax.swing.JPanel implements ItemListener {

    private EdgeColorPropertyEditor propertyEditor;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton colorButton;
    private javax.swing.JRadioButton customRadio;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JRadioButton mixedRadio;
    private javax.swing.JRadioButton originalRadio;
    private javax.swing.JRadioButton sourceRadio;
    private javax.swing.JRadioButton targetRadio;
    /**
     * Creates new form EdgeColorPanel
     */
    public EdgeColorPanel() {
        initComponents();

        colorButton.addPropertyChangeListener(JColorButton.EVENT_COLOR, new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                Color newColor = (Color) evt.getNewValue();
                propertyEditor.setValue(new EdgeColor(newColor));
            }
        });

        originalRadio.addItemListener(this);
        mixedRadio.addItemListener(this);
        sourceRadio.addItemListener(this);
        targetRadio.addItemListener(this);
        customRadio.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (customRadio.isSelected()) {
            colorButton.setEnabled(true);
        } else {
            colorButton.setEnabled(false);
        }
        EdgeColor.Mode selectedMode = null;
        if (originalRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.ORIGINAL;
        } else if (mixedRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.MIXED;
        } else if (sourceRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.SOURCE;
        } else if (targetRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.TARGET;
        } else if (customRadio.isSelected()) {
            selectedMode = EdgeColor.Mode.CUSTOM;
        }
        propertyEditor.setValue(new EdgeColor(selectedMode));
    }

    public void setup(EdgeColorPropertyEditor propertyEditor) {
        this.propertyEditor = propertyEditor;
        EdgeColor edgeColor = (EdgeColor) propertyEditor.getValue();
        if (edgeColor.getMode().equals(EdgeColor.Mode.CUSTOM)) {
            customRadio.setSelected(true);
            ((JColorButton) colorButton).setColor(edgeColor.getCustomColor());
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.MIXED)) {
            mixedRadio.setSelected(true);
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.ORIGINAL)) {
            originalRadio.setSelected(true);
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.SOURCE)) {
            sourceRadio.setSelected(true);
        } else if (edgeColor.getMode().equals(EdgeColor.Mode.TARGET)) {
            targetRadio.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        originalRadio = new javax.swing.JRadioButton();
        mixedRadio = new javax.swing.JRadioButton();
        sourceRadio = new javax.swing.JRadioButton();
        targetRadio = new javax.swing.JRadioButton();
        customRadio = new javax.swing.JRadioButton();
        colorButton = new JColorButton(Color.BLACK);

        jXHeader1.setDescription(org.openide.util.NbBundle
            .getMessage(EdgeColorPanel.class, "EdgeColorPanel.jXHeader1.description")); // NOI18N
        jXHeader1.setTitle(
            org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.jXHeader1.title")); // NOI18N

        buttonGroup1.add(originalRadio);
        originalRadio.setText(
            org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.originalRadio.text")); // NOI18N

        buttonGroup1.add(mixedRadio);
        mixedRadio.setText(
            org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.mixedRadio.text")); // NOI18N

        buttonGroup1.add(sourceRadio);
        sourceRadio.setText(
            org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.sourceRadio.text")); // NOI18N

        buttonGroup1.add(targetRadio);
        targetRadio.setText(
            org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.targetRadio.text")); // NOI18N

        buttonGroup1.add(customRadio);
        customRadio.setText(
            org.openide.util.NbBundle.getMessage(EdgeColorPanel.class, "EdgeColorPanel.customRadio.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(originalRadio)
                        .addComponent(mixedRadio)
                        .addComponent(sourceRadio)
                        .addComponent(targetRadio)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(customRadio)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(colorButton)))
                    .addContainerGap(323, Short.MAX_VALUE))
                .addComponent(jXHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 81,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(originalRadio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(mixedRadio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(sourceRadio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(targetRadio)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(customRadio)
                        .addComponent(colorButton))
                    .addContainerGap(7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables
}
