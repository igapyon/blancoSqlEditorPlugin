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

import org.eclipse.swt.graphics.RGB;

/**
 * BlancoSqlEditorプラグインのハイライト表示関連処理 <br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author Toshiki Iga ハイライト表示機能の追加
 */
public interface ISQLColorConstants {
	RGB SQL_COMMENT = new RGB(0, 192, 0);

	RGB SQL_STRING_QUOTE = new RGB(192, 96, 0);

	RGB SQL_STRING_DOUBLEQUOTE = new RGB(128, 96, 64);

	RGB DEFAULT = new RGB(0, 0, 0);

	RGB ANSI_SQL89 = new RGB(255, 0, 255);

	RGB ANSI_SQL92 = new RGB(192, 0, 255);

	RGB ANSI_SQL99 = new RGB(96, 0, 255);

	RGB SQL_FAMOUS = new RGB(0, 128, 255);
}
