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

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

import blanco.commons.sql.format.BlancoSqlConstants;

/**
 * BlancoSqlEditorプラグインのハイライト表示関連処理 <br>
 * 2005.08.06 Tosiki Iga ハイライト表示機能の追加
 * 
 * @author Toshiki Iga ハイライト表示機能の追加
 */
public class SQLScanner extends RuleBasedScanner {

    public SQLScanner(ColorManager manager) {
        IRule[] rules = new IRule[4];
        // Add rule for processing instructions
        // バックスラッシュはエスケープコードと判断します。
        rules[0] = new SingleLineRule("\"", "\"", new Token(new TextAttribute(
                manager.getColor(ISQLColorConstants.SQL_STRING_DOUBLEQUOTE))),
                '\\');
        // バックスラッシュはエスケープコードと判断します。
        rules[1] = new SingleLineRule("\'", "\'", new Token(new TextAttribute(
                manager.getColor(ISQLColorConstants.SQL_STRING_QUOTE))), '\\');
        rules[2] = new BlancoSQLRule(new Token(new TextAttribute(manager
                .getColor(ISQLColorConstants.ANSI_SQL89))),
                BlancoSqlConstants.SQL89_RESERVED_WORDS, new Token(
                        new TextAttribute(manager
                                .getColor(ISQLColorConstants.ANSI_SQL92))),
                BlancoSqlConstants.SQL92_RESERVED_WORDS, new Token(
                        new TextAttribute(manager
                                .getColor(ISQLColorConstants.ANSI_SQL99))),
                BlancoSqlConstants.SQL99_RESERVED_WORDS, new Token(
                        new TextAttribute(manager
                                .getColor(ISQLColorConstants.SQL_FAMOUS))),
                BlancoSqlConstants.SQL_FAMOUS_WORDS);
        rules[3] = new WhitespaceRule(new SQLWhitespaceDetector());

        setRules(rules);
    }
}
