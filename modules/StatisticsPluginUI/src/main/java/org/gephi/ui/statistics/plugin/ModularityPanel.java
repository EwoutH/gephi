/*
Copyright 2008-2010 Gephi
Authors : Patick J. McSweeney <pjmcswee@syr.edu>
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

package org.gephi.ui.statistics.plugin;

/**
 * @author pjmcswee
 */
public class ModularityPanel extends javax.swing.JPanel {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXLabel desriptionLabel;
    private org.jdesktop.swingx.JXHeader header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelEdgeWeight;
    private javax.swing.JLabel labelRandomize;
    private org.jdesktop.swingx.JXLabel labelResolution;
    private javax.swing.JCheckBox randomizeCheckbox;
    private javax.swing.JTextField resolutionTextField;
    private javax.swing.JCheckBox useWeightCheckbox;
    public ModularityPanel() {
        initComponents();
    }

    public boolean isRandomize() {
        return randomizeCheckbox.isSelected();
    }

    public void setRandomize(boolean randomize) {
        randomizeCheckbox.setSelected(randomize);
    }

    public boolean useWeight() {
        return useWeightCheckbox.isSelected();
    }

    public void setUseWeight(boolean useWeight) {
        useWeightCheckbox.setSelected(useWeight);
    }

    public double resolution() {
        try {
            return Double.valueOf(resolutionTextField.getText());
        } catch (Exception e) {

        }

        return 1.0;
    }

    public void setResolution(double resolution) {
        resolutionTextField.setText(String.valueOf(resolution));
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

        randomizeCheckbox = new javax.swing.JCheckBox();
        desriptionLabel = new org.jdesktop.swingx.JXLabel();
        header = new org.jdesktop.swingx.JXHeader();
        useWeightCheckbox = new javax.swing.JCheckBox();
        resolutionTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelEdgeWeight = new javax.swing.JLabel();
        labelRandomize = new javax.swing.JLabel();
        labelResolution = new org.jdesktop.swingx.JXLabel();

        randomizeCheckbox.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.randomizeCheckbox.text")); // NOI18N
        randomizeCheckbox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        desriptionLabel.setLineWrap(true);
        desriptionLabel.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.desriptionLabel.text")); // NOI18N
        desriptionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        header.setDescription(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.header.description")); // NOI18N
        header.setTitle(
            org.openide.util.NbBundle.getMessage(ModularityPanel.class, "ModularityPanel.header.title")); // NOI18N

        useWeightCheckbox.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.useWeightCheckbox.text")); // NOI18N

        resolutionTextField.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.resolutionTextField.text")); // NOI18N
        resolutionTextField.setToolTipText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.resolutionTextField.toolTipText")); // NOI18N

        jLabel1.setText(
            org.openide.util.NbBundle.getMessage(ModularityPanel.class, "ModularityPanel.jLabel1.text")); // NOI18N

        labelEdgeWeight.setFont(labelEdgeWeight.getFont().deriveFont(labelEdgeWeight.getFont().getSize() - 1f));
        labelEdgeWeight.setForeground(new java.awt.Color(102, 102, 102));
        labelEdgeWeight.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.labelEdgeWeight.text")); // NOI18N

        labelRandomize.setFont(labelRandomize.getFont().deriveFont(labelRandomize.getFont().getSize() - 1f));
        labelRandomize.setForeground(new java.awt.Color(102, 102, 102));
        labelRandomize.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.labelRandomize.text")); // NOI18N

        labelResolution.setForeground(new java.awt.Color(102, 102, 102));
        labelResolution.setLineWrap(true);
        labelResolution.setText(org.openide.util.NbBundle
            .getMessage(ModularityPanel.class, "ModularityPanel.labelResolution.text")); // NOI18N
        labelResolution.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelResolution.setFont(labelResolution.getFont().deriveFont(labelResolution.getFont().getSize() - 1f));
        labelResolution.setPreferredSize(new java.awt.Dimension(500, 12));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(63, 63, 63)
                            .addComponent(desriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(381, 381, 381))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(randomizeCheckbox)
                                    .addGap(25, 25, 25)
                                    .addComponent(labelRandomize, javax.swing.GroupLayout.DEFAULT_SIZE, 386,
                                        Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(useWeightCheckbox)
                                        .addComponent(resolutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                            javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelResolution, javax.swing.GroupLayout.DEFAULT_SIZE, 0,
                                            Short.MAX_VALUE)
                                        .addComponent(labelEdgeWeight, javax.swing.GroupLayout.DEFAULT_SIZE,
                                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(randomizeCheckbox)
                        .addComponent(labelRandomize))
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(useWeightCheckbox)
                        .addComponent(labelEdgeWeight))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(resolutionTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(labelResolution, javax.swing.GroupLayout.DEFAULT_SIZE,
                            javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(26, 26, 26)
                    .addComponent(desriptionLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // End of variables declaration//GEN-END:variables
}
