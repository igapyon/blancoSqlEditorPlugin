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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.ide.IDE;

import blanco.commons.sql.format.BlancoSqlFormatter;
import blanco.commons.sql.format.BlancoSqlFormatterException;
import blanco.commons.sql.format.BlancoSqlRule;
import blanco.plugin.sqleditor.BlancoSqlEditorPlugin;

/**
 * BlancoSqlEditorプラグインのコントリビューター <br>
 * メニューとステータスバー更新の機能が付与されています。
 * 
 * @author sari オリジナル版の開発
 * @author Toshiki Iga プラグイン部分の改変
 */
public class BlancoSqlEditorContributor extends TextEditorActionContributor {
	private Action menuAction = null;

	private IStatusLineManager statusLineManager = null;

	public BlancoSqlEditorContributor() {
		super();
		createActions();
	}

	private void createActions() {
		menuAction = new Action() {
			public void run() {
				try {
					statusLineManager.setMessage(BlancoSqlEditorPlugin.getResourceBundle().getMsg0001());

					IEditorPart activeEditor = getPage().getActiveEditor();

					TextEditor editor = (activeEditor instanceof TextEditor) ? (TextEditor) activeEditor : null;
					if (editor != null) {
						editor.showBusy(true);
						String editorText = editor.getDocumentProvider().getDocument(editor.getEditorInput()).get();

						BlancoSqlFormatter formatter = new BlancoSqlFormatter(new BlancoSqlRule());
						try {
							String editorTextAfter = formatter.format(editorText);
							if (editorText.equals(editorTextAfter) == false) {
								editor.getDocumentProvider().getDocument(editor.getEditorInput()).set(editorTextAfter);

								editor.showChangeInformation(true);
								statusLineManager.setMessage(BlancoSqlEditorPlugin.getResourceBundle().getMsg0002());
							} else {
								statusLineManager.setMessage(BlancoSqlEditorPlugin.getResourceBundle().getMsg0003());
							}
						} catch (BlancoSqlFormatterException ex) {
							// SQL整形の際の例外は ステータスバーには(エラーではない)メッセージとして表示します。
							// なぜなら、エラーとして表示すると、プラグインのアクションそのものが無効化してしまうようだからです。
							statusLineManager.setMessage(
									BlancoSqlEditorPlugin.getResourceBundle().getMsg0004() + ":" + ex.toString());
						}

						editor.showBusy(false);
					} else {
						statusLineManager.setErrorMessage("fail to get editor during SQL formatting.");
					}
				} catch (Exception ex) {
					statusLineManager
							.setErrorMessage("unexpected exception occurs during SQL formatting." + ex.toString());
				}
			}
		};

		menuAction.setText(BlancoSqlEditorPlugin.getResourceBundle().getMenu0002());
		menuAction.setToolTipText(BlancoSqlEditorPlugin.getResourceBundle().getMENU0002ToolTip());
		menuAction.setAccelerator(SWT.CTRL | SWT.SHIFT | 'F');
		menuAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(IDE.SharedImages.IMG_OBJS_TASK_TSK));
	}

	public void contributeToMenu(IMenuManager manager) {
		super.contributeToMenu(manager);
		IMenuManager menu = new MenuManager(BlancoSqlEditorPlugin.getResourceBundle().getMenu0001());
		manager.prependToGroup(IWorkbenchActionConstants.MB_ADDITIONS, menu);
		menu.add(menuAction);
	}

	public void contributeToToolBar(IToolBarManager manager) {
		super.contributeToToolBar(manager);
		manager.add(new Separator());
		manager.add(menuAction);
	}

	public void contributeToStatusLine(IStatusLineManager statusLineManager) {
		super.contributeToStatusLine(statusLineManager);
		this.statusLineManager = statusLineManager;
	}
}
