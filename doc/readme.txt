SQLを整形するEclipseプラグイン「BlancoSqlEditorPlugin」
blancoSqlEditorPlugin は SQL整形機能を持った シンプルなSQL編集プラグインです。

1.「*.sql」に対してBlancoSqlEditorPluginテキストエディタを関連付けます。
  SQL予約語などについてカラー表示をおこなうことができます。
2.一般的なテキストエディタ (#TextEditorContext) に対して
  ポップアップメニュー 「Format as SQL」 を追加します。

[特徴]
 フリーで強力なSQL整形機能が特徴です。

[ライセンス]
 1.blancoSqlEditorPlugin は ライセンス として GNU Lesser General Public License (LGPL) を
   採用しています。詳細は lesser.txtをご覧ください。

[開発者]
 1.猿橋大介 (sari) : プラグインの初期バージョンの開発
 2.渡辺義則 (a-san): SQL整形エンジンの初期バージョンの開発
 3.伊賀敏樹 (Tosiki Iga / いがぴょん): 最新版の維持メンテ担当
 4.内林宏武 (うっちー) : アイコンの作成
 5.山本耕司 (Y-moto) : プラグインのリリース判定担当

[依存するライブラリ]
blancoSqlEditorPluginは下記のライブラリを利用しています。
 1.blancoCommons
   GNU LGPLライセンス

[トラブルシュート]
 1.Eclipseエディタ上で字下げが妙な場合
   ※Eclipseのフォント設定が起因して字下げが不正に見えている可能性があります。(国際化パック未適用の場合)
     下記の手順で回復することが出来る可能性があります。
     (1) Eclipse のWindow -> Preferences... メニューを開きます。
     (3) General -> Appearance -> Colors and Fonts
     (4) Basic -> Text Font
         を開いて、Change → フォント名
         のところで、MSゴシックなどの日本語対応非プロポーショナルフォント
         に変更するとうまく表示できるように改善される可能性があります。
