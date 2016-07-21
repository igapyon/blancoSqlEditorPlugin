/*
 * blancoSqlEditorPlugin
 * Copyright (C) 2005 sari
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */

package blanco.plugin.sqleditor.editors;

import org.eclipse.ui.editors.text.TextEditor;

/**
 * BlancoSqlEditor�v���O�C���̖{�� <br>
 * ��{�I�� TextEditor���̂܂܂ł��B<br>
 * 2005.08.06 Tosiki Iga �n�C���C�g�\���@�\�̒ǉ�
 * 
 * @author sari �I���W�i���ł̊J��
 * @author Toshiki Iga �v���O�C�������̉���
 */
public class BlancoSqlEditor extends TextEditor {
    private ColorManager colorManager;

    public BlancoSqlEditor() {
        super();
        // System.out.println("trace 1");
        colorManager = new ColorManager();
        // System.out.println("trace 2");
        setSourceViewerConfiguration(new SQLConfiguration(colorManager));
        // System.out.println("trace 3");
        setDocumentProvider(new SQLDocumentProvider());
    }

    public void dispose() {
        colorManager.dispose();
        super.dispose();
    }
}
