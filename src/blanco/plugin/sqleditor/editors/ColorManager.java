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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

/**
 * BlancoSqlEditorプラグインのハイライト表示関連処理 <br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author Toshiki Iga ハイライト表示機能の追加
 */
public class ColorManager {

	protected Map fColorTable = new HashMap(20);

	public void dispose() {
		Iterator e = fColorTable.values().iterator();
		while (e.hasNext())
			((Color) e.next()).dispose();
	}

	public Color getColor(RGB rgb) {
		Color color = (Color) fColorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			fColorTable.put(rgb, color);
		}
		return color;
	}
}
