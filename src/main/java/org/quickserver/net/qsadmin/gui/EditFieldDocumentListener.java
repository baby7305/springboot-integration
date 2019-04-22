/*
 * This file is part of the QuickServer library
 * Copyright (C) QuickServer.org
 *
 * Use, modification, copying and distribution of this software is subject to
 * the terms and conditions of the GNU Lesser General Public License.
 * You should have received a copy of the GNU LGP License along with this
 * library; if not, you can download a copy from <http://www.quickserver.org/>.
 *
 * For questions, suggestions, bug-reports, enhancement-requests etc.
 * visit http://www.quickserver.org
 *
 */

package org.quickserver.net.qsadmin.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditFieldDocumentListener implements DocumentListener {
	JButton saveButton;

	public EditFieldDocumentListener(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public void insertUpdate(DocumentEvent e) {
		if (saveButton != null) saveButton.setEnabled(true);
	}

	public void removeUpdate(DocumentEvent e) {
		if (saveButton != null) saveButton.setEnabled(true);
	}

	public void changedUpdate(DocumentEvent e) {
		//System.out.println(">>Change Update");
		//if(saveButton!=null) saveButton.setEnabled(true);
	}
}    

