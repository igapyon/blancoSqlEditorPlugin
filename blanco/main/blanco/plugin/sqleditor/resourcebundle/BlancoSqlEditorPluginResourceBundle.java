/*
 * このソースコードは blanco Frameworkによって自動生成されています。
 * リソースバンドル定義書から作成されたリソースバンドルクラス。
 */
package blanco.plugin.sqleditor.resourcebundle;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * リソースバンドル定義[BlancoSqlEditorPlugin]のリソースバンドルクラス。
 *
 * このクラスはリソースバンドル定義書から自動生成されたリソースバンドルクラスです。<BR>
 * 既知のロケール<BR>
 * <UL>
 * <LI>en
 * <LI>ja
 * </UL>
 */
public class BlancoSqlEditorPluginResourceBundle {
    /**
     * リソースバンドルオブジェクト。
     *
     * 内部的に実際に入力を行うリソースバンドルを記憶します。
     */
    private ResourceBundle fResourceBundle;

    /**
     * BlancoSqlEditorPluginResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoSqlEditorPlugin]、デフォルトのロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     */
    public BlancoSqlEditorPluginResourceBundle() {
        try {
            fResourceBundle = ResourceBundle.getBundle("BlancoSqlEditorPlugin");
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoSqlEditorPluginResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoSqlEditorPlugin]、指定されたロケール、呼び出し側のクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     */
    public BlancoSqlEditorPluginResourceBundle(final Locale locale) {
        try {
            fResourceBundle = ResourceBundle.getBundle("BlancoSqlEditorPlugin", locale);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * BlancoSqlEditorPluginResourceBundleクラスのコンストラクタ。
     *
     * 基底名[BlancoSqlEditorPlugin]、指定されたロケール、指定されたクラスローダを使用して、リソースバンドルを取得します。
     *
     * @param locale ロケールの指定
     * @param loader クラスローダの指定
     */
    public BlancoSqlEditorPluginResourceBundle(final Locale locale, final ClassLoader loader) {
        try {
            fResourceBundle = ResourceBundle.getBundle("BlancoSqlEditorPlugin", locale, loader);
        } catch (MissingResourceException ex) {
        }
    }

    /**
     * 内部的に保持しているリソースバンドルオブジェクトを取得します。
     *
     * @return 内部的に保持しているリソースバンドルオブジェクト。
     */
    public ResourceBundle getResourceBundle() {
        return fResourceBundle;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MENU0001]
     *
     * [&amp;SQL] (en)<br>
     * [SQL(&amp;S)] (ja)<br>
     *
     * @return key[MENU0001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMenu0001() {
        // 初期値として定義書の値を利用します。
        String strFormat = "&SQL";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MENU0001");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MENU0002]
     *
     * [F&amp;ormat] (en)<br>
     * [フォーマット(&amp;O)] (ja)<br>
     *
     * @return key[MENU0002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMenu0002() {
        // 初期値として定義書の値を利用します。
        String strFormat = "F&ormat";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MENU0002");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MENU0002ToolTip]
     *
     * [Format SQL] (en)<br>
     * [SQLを整形します] (ja)<br>
     *
     * @return key[MENU0002ToolTip]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMENU0002ToolTip() {
        // 初期値として定義書の値を利用します。
        String strFormat = "Format SQL";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MENU0002ToolTip");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0001]
     *
     * [Format SQL: begin.] (en)<br>
     * [SQL整形を実行開始します.] (ja)<br>
     *
     * @return key[MSG0001]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMsg0001() {
        // 初期値として定義書の値を利用します。
        String strFormat = "Format SQL: begin.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0001");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0002]
     *
     * [Format SQL: done.] (en)<br>
     * [SQL整形が実行されました.] (ja)<br>
     *
     * @return key[MSG0002]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMsg0002() {
        // 初期値として定義書の値を利用します。
        String strFormat = "Format SQL: done.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0002");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0003]
     *
     * [Format SQL: no necessity to format.] (en)<br>
     * [SQL整形の必要はありません.] (ja)<br>
     *
     * @return key[MSG0003]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMsg0003() {
        // 初期値として定義書の値を利用します。
        String strFormat = "Format SQL: no necessity to format.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0003");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }

    /**
     * bundle[BlancoSqlEditorPlugin], key[MSG0004]
     *
     * [Format SQL: exception occurs during SQL formatting. Check SQL is valid.] (en)<br>
     * [SQL整形の過程で例外が発生しました. SQL文が正しいかどうかチェックしてください.] (ja)<br>
     *
     * @return key[MSG0004]に対応する値。外部から読み込みができない場合には、定義書の値を戻します。必ずnull以外の値が戻ります。
     */
    public String getMsg0004() {
        // 初期値として定義書の値を利用します。
        String strFormat = "Format SQL: exception occurs during SQL formatting. Check SQL is valid.";
        try {
            if (fResourceBundle != null) {
                strFormat = fResourceBundle.getString("MSG0004");
            }
        } catch (MissingResourceException ex) {
        }
        // 置換文字列はひとつもありません。
        return strFormat;
    }
}
