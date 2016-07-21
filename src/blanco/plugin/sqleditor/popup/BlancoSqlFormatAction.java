/*
 * blancoSqlEditorPlugin Copyright (C) 2005 sari
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 */

package blanco.plugin.sqleditor.popup;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.AbstractTextEditor;

import blanco.commons.sql.format.BlancoSqlFormatter;
import blanco.commons.sql.format.BlancoSqlFormatterException;
import blanco.commons.sql.format.BlancoSqlRule;

/**
 * �E�N���b�N���j���[�ɂ��SQL���`���������܂��B <br>
 * #TextEditorContext �ɑ΂��ă|�b�v�A�b�v���j���[�uFormat as SQL�v��ǉ����܂��B
 * 
 * @author sari �����o�[�W�������쐬
 * @author Tosiki Iga �N���X���Ȃǂ𒲐�
 */
public class BlancoSqlFormatAction implements IEditorActionDelegate {

    private IWorkbenchPart activeEditor = null;

    private ITextSelection activeSelection = null;

    private BlancoSqlFormatter formatter = null;

    /**
     * ���̃N���X�̃R���X�g���N�^
     */
    public BlancoSqlFormatAction() {
        super();
    }

    /**
     * �A�N�e�B�u�ȃG�f�B�^���Z�b�g���܂��B
     */
    public void setActiveEditor(IAction action, IEditorPart targetEditor) {
        activeEditor = targetEditor;
    }

    /**
     * �I�����ύX���ꂽ�ۂɌĂяo����܂��B
     */
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection instanceof ITextSelection) {
            activeSelection = (ITextSelection) selection;
        }
    }

    /**
     * ���ۂɏ��������s���܂��B
     */
    public void run(IAction action) {
        if (activeEditor != null) {
            if (formatter == null) {
                formatter = new BlancoSqlFormatter(new BlancoSqlRule());
            }

            try {
                getDocument().replace(activeSelection.getOffset(),
                        activeSelection.getLength(),
                        formatter.format(activeSelection.getText()));
            } catch (BlancoSqlFormatterException ex) {
                // ���ɉ������܂���B
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * �h�L�������g�I�u�W�F�N�g���擾���܂��B
     * 
     * @return �h�L�������g�I�u�W�F�N�g
     */
    protected IDocument getDocument() {
        if (activeEditor != null) {
            if (activeEditor instanceof AbstractTextEditor) {
                AbstractTextEditor editor = (AbstractTextEditor) activeEditor;
                IDocument document = editor.getDocumentProvider().getDocument(
                        editor.getEditorInput());
                return document;
            }
        }
        return null;
    }
}
