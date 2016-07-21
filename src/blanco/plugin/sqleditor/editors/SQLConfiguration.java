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

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * BlancoSqlEditorプラグインのハイライト表示関連処理 <br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author Toshiki Iga ハイライト表示機能の追加
 */
public class SQLConfiguration extends SourceViewerConfiguration {
	private SQLScanner scanner;

	private ColorManager colorManager;

	public SQLConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}

	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] { IDocument.DEFAULT_CONTENT_TYPE, SQLPartitionScanner.SQL_COMMENT,
				SQLPartitionScanner.SQL89, SQLPartitionScanner.SQL92, SQLPartitionScanner.SQL99,
				SQLPartitionScanner.SQL_FAMOUS, SQLPartitionScanner.SQL_STRING };
	}

	protected SQLScanner getSQLScanner() {
		if (scanner == null) {
			scanner = new SQLScanner(colorManager);
			scanner.setDefaultReturnToken(
					new Token(new TextAttribute(colorManager.getColor(ISQLColorConstants.DEFAULT))));
		}
		return scanner;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getSQLScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(
				new TextAttribute(colorManager.getColor(ISQLColorConstants.SQL_COMMENT)));
		reconciler.setDamager(ndr, SQLPartitionScanner.SQL_COMMENT);
		reconciler.setRepairer(ndr, SQLPartitionScanner.SQL_COMMENT);

		return reconciler;
	}
}