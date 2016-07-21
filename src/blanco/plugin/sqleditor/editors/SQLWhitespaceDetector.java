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

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * BlancoSqlEditorプラグインのハイライト表示関連処理 <br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author Toshiki Iga ハイライト表示機能の追加
 */
public class SQLWhitespaceDetector implements IWhitespaceDetector {

	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}
}
