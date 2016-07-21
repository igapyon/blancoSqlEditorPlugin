/*
 * blancoSqlEditorPlugin
 * Copyright (C) 2005 Tosiki Iga
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 */

package blanco.plugin.sqleditor.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.DefaultPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

/**
 * BlancoSqlEditor�v���O�C���̃n�C���C�g�\���֘A���� <br>
 * 2005.08.06 Tosiki Iga �n�C���C�g�\���@�\�̒ǉ�
 * 
 * @author Toshiki Iga �n�C���C�g�\���@�\�̒ǉ�
 */
public class SQLDocumentProvider extends FileDocumentProvider {

    protected IDocument createDocument(Object element) throws CoreException {
        IDocument document = super.createDocument(element);
        if (document != null) {
            /**
             * Eclipse 3.0�Ƃ̌݊�������邽�߂� DefaultPartitioner �𗘗p������𓾂܂���B
             */
            IDocumentPartitioner partitioner = new DefaultPartitioner(
                    new SQLPartitionScanner(), new String[] {
                            SQLPartitionScanner.SQL89,
                            SQLPartitionScanner.SQL92,
                            SQLPartitionScanner.SQL99,
                            SQLPartitionScanner.SQL_FAMOUS,
                            SQLPartitionScanner.SQL_COMMENT });
            partitioner.connect(document);
            document.setDocumentPartitioner(partitioner);
        }
        return document;
    }
}