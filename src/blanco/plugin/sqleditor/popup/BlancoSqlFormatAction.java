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
 * 右クリックメニューによるSQL整形を実現します。 <br>
 * #TextEditorContext に対してポップアップメニュー「Format as SQL」を追加します。
 * 
 * @author sari 初期バージョンを作成
 * @author Tosiki Iga クラス名などを調整
 */
public class BlancoSqlFormatAction implements IEditorActionDelegate {

	private IWorkbenchPart activeEditor = null;

	private ITextSelection activeSelection = null;

	private BlancoSqlFormatter formatter = null;

	/**
	 * このクラスのコンストラクタ
	 */
	public BlancoSqlFormatAction() {
		super();
	}

	/**
	 * アクティブなエディタをセットします。
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		activeEditor = targetEditor;
	}

	/**
	 * 選択が変更された際に呼び出されます。
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof ITextSelection) {
			activeSelection = (ITextSelection) selection;
		}
	}

	/**
	 * 実際に処理を実行します。
	 */
	public void run(IAction action) {
		if (activeEditor != null) {
			if (formatter == null) {
				formatter = new BlancoSqlFormatter(new BlancoSqlRule());
			}

			try {
				getDocument().replace(activeSelection.getOffset(), activeSelection.getLength(),
						formatter.format(activeSelection.getText()));
			} catch (BlancoSqlFormatterException ex) {
				// 特に何もしません。
			} catch (BadLocationException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * ドキュメントオブジェクトを取得します。
	 * 
	 * @return ドキュメントオブジェクト
	 */
	protected IDocument getDocument() {
		if (activeEditor != null) {
			if (activeEditor instanceof AbstractTextEditor) {
				AbstractTextEditor editor = (AbstractTextEditor) activeEditor;
				IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
				return document;
			}
		}
		return null;
	}
}
