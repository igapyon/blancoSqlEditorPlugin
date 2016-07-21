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

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * BlancoSqlEditorプラグインのハイライト表示関連処理 <br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author Toshiki Iga ハイライト表示機能の追加
 */
public class SQLPartitionScanner extends RuleBasedPartitionScanner {
	public final static String SQL_DEFAULT = "__sql_default";

	public final static String SQL89 = "__sql89_tag";

	public final static String SQL92 = "__sql92_tag";

	public final static String SQL99 = "__sql99_tag";

	public final static String SQL_STRING = "__sql_string";

	public final static String SQL_FAMOUS = "__sql_famous_tag";

	public final static String SQL_COMMENT = "__sql_comment";

	public SQLPartitionScanner() {
		IPredicateRule[] rules = new IPredicateRule[2];
		rules[0] = new MultiLineRule("/*", "*/", new Token(SQL_COMMENT));
		rules[1] = new EndOfLineRule("--", new Token(SQL_COMMENT));

		setPredicateRules(rules);
	}
}
