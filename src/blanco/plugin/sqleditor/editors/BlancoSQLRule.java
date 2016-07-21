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

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

import blanco.commons.sql.format.BlancoSqlParser;

/**
 * SQLハイライト表示のためのルールを提供します。<br>
 * 2005.08.14 Tosiki Iga: 文字列の途中に数値が含まれることに対応。<br>
 * 2005.08.12 Tosiki Iga: blancoCommonsの文字列判定ルーチンを利用するように変更。<br>
 * 
 * @author Tosiki Iga
 */
public class BlancoSQLRule extends WordRule implements IPredicateRule {

    private IToken fSuccessTokenTotal;

    private IToken fSuccessToken89;

    private IToken fSuccessToken92;

    private IToken fSuccessToken99;

    private IToken fSuccessTokenFamous;

    /**
     * SQLハイライト表示のためのルールのコンストラクタです。
     * 
     * @param successToken
     * @param sqlKeywords
     *            SQLキーワードを与えてください。
     */
    public BlancoSQLRule(IToken successToken89, String[] sqlKeywords89,
            IToken successToken92, String[] sqlKeywords92,
            IToken successToken99, String[] sqlKeywords99,
            IToken successTokenFamous, String[] sqlKeywordsFamous) {
        super(new BlancoSQLDetector(), new Token(
                SQLPartitionScanner.SQL_DEFAULT));
        fSuccessToken89 = successToken89;
        fSuccessToken92 = successToken92;
        fSuccessToken99 = successToken99;
        fSuccessTokenFamous = successTokenFamous;
        for (int i = 0; i < sqlKeywords89.length; i++) {
            addWord(sqlKeywords89[i], successToken89);
            addWord(sqlKeywords89[i].toLowerCase(), successToken89);
        }
        for (int i = 0; i < sqlKeywords92.length; i++) {
            addWord(sqlKeywords92[i], successToken92);
            addWord(sqlKeywords92[i].toLowerCase(), successToken92);
        }
        for (int i = 0; i < sqlKeywords99.length; i++) {
            addWord(sqlKeywords99[i], successToken99);
            addWord(sqlKeywords99[i].toLowerCase(), successToken99);
        }
        for (int i = 0; i < sqlKeywordsFamous.length; i++) {
            addWord(sqlKeywordsFamous[i], successTokenFamous);
            addWord(sqlKeywordsFamous[i].toLowerCase(), successTokenFamous);
        }
    }

    public IToken evaluate(ICharacterScanner scanner, boolean resume) {
        return evaluate(scanner);
    }

    public IToken evaluate(ICharacterScanner scanner) {
        IToken result = super.evaluate(scanner);
        if (result == fSuccessToken89) {
            fSuccessTokenTotal = result;
        } else if (result == fSuccessToken92) {
            fSuccessTokenTotal = result;
        } else if (result == fSuccessToken99) {
            fSuccessTokenTotal = result;
        } else if (result == fSuccessTokenFamous) {
            fSuccessTokenTotal = result;
        }
        return result;
    }

    public IToken getSuccessToken() {
        return fSuccessTokenTotal;
    }

    /**
     * SQL文のキーワード判定を行います。
     * 
     * @author iga
     */
    static class BlancoSQLDetector implements IWordDetector {
        /**
         * 文字列開始判定を行います<br>
         * Eclipse Platformの個性により、Eclipse 3.1において
         * 65535(もとは-1)という特殊な値が入ってくることが知られています。
         */
        public boolean isWordStart(char character) {
            return BlancoSqlParser.isLetter(character);
        }

        /**
         * 文字列の途中であるかどうかの判定を行います<Br>
         * 文字の途中には数字が出現し得ることが知られています。このため、isLetterと共に
         * isDigitを用いて、文字と数値に該当するかどうかの判定を行っています。
         */
        public boolean isWordPart(char character) {
            return (BlancoSqlParser.isLetter(character) || BlancoSqlParser
                    .isDigit(character));
        }
    }
};
