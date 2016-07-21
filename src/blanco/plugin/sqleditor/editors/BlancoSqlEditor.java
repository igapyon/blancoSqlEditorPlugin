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
 * BlancoSqlEditorプラグインの本体 <br>
 * 基本的に TextEditorそのままです。<br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author sari オリジナル版の開発
 * @author Toshiki Iga プラグイン部分の改変
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
