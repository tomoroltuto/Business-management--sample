# Business-management-application
業務管理アプリケーション

# 概要
下請業者との作業内容を共有する為の管理システム

# 背景
現在、電気設備工事の現場監督（サブゼネコン）として働いています。建築（ゼネコン）との業務管理はアプリケーションで管理しておりますが、サブゼネコンとの下請け業者とはアナログ管理でしています。


<h2> 組織構成図 </h2>
  
![業務管理体制](https://user-images.githubusercontent.com/90845405/197956867-5e2f7fb5-2304-4661-b943-a199945303c8.jpg)

アナログ管理とは、口頭や電話などでメモしたりやペーパー等に記入するという意味で、それによる聞き漏れや聞き忘れ等が発生や何十社と電話で確認をするのに時間がかかります。


<h2>アナログ管理イメージ図 </h2>

![analog](https://user-images.githubusercontent.com/90845405/197953637-df706a90-57e0-4cfa-b8be-838ff5170d64.jpg)

そこで、対策としてGoogle Apps Script（GAS）+　Google Forms　＋　Lineを連携したLine自動通知送信システムを開発し運用しています。


<h2> Line自動通知送信システム構成図 </h2>

![line](https://user-images.githubusercontent.com/90845405/197954691-cb1dbcda-2167-4ea3-898a-2f76a6a079bd.jpg)

上記のシステムにより、電話をする時間から解放され、どこの会社が何の業務をしているかを共有化できました。
しかし、運用していて以下のでデメリットがありました。

* 業務内容の更新・削除ができない
* 下請業者が多くなるとLineをスクロールして確認するのが大変
* 過去の業務を確認はできるが探すのが大変

これらを解決できるアプリケーションを開発したいと思います。

# アプリケーションを導入して改善できること

* 作業予定・作業実績を登録・編集・削除できる
* 作業予定・作業実績の一覧表を表示できる
* 過去の作業予定・作業実績の履歴を検索できる

# アプリケーションを導入したシステムの構成図

![新Lineシステム](https://user-images.githubusercontent.com/90845405/201008317-bff00551-7c7a-4e39-87b9-267f247c85cd.jpg)


# 設計書

<h2>アクティビティ図(全体像)</h2>

全体の以下の通りです。

![スイムレーン図(全体像)](https://user-images.githubusercontent.com/90845405/201112569-0077edd9-1d50-4d6f-8700-4df55ce93f44.jpg)


<h2>アクティビティ図(実装する箇所)</h2

全体像の中で赤色の箇所を実装していきたいと思います。

![スイムレーン図(実装箇所)](https://user-images.githubusercontent.com/90845405/201112620-160e8099-f63e-49ea-9cd6-55c6cfbe4d8f.jpg)


その上で以下の実装機能をしていきます。

## 基本機能

| | 機能 | 
| :---: | :---: | 
| 1 | ログイン機能 | 

## 作業予定機能

| | 機能 | 
| :---: | :---: | 
| ２ | 作業予定登録・編集・削除機能 | 
| 3 | 作業予定一覧表機能 | 
| 4 | 作業予定検索機能 | 

## 作業実績機能

| | 機能 | 
| :---: | :---: | 
| 5 | 作業実績登録・編集・削除機能 | 
| 6 | 作業実績一覧表表示機能 | 
| 7 | 作業実績検索機能 | 


## 外部連携機能

| | 機能 | 
| :---: | :---: | 
| 8 | Line連携機能  | 

<h2>ER図</h2>

![ER図](https://user-images.githubusercontent.com/90845405/201934297-650bcf1c-b119-4502-b55d-a776db4d3c0a.jpg)


<h2>URL設計書</h2>

![HTTP＋URL](https://user-images.githubusercontent.com/90845405/201934338-d88cc805-79b3-426f-a28c-a9aded8d39bf.jpg)


<h2>画面遷移図</h2>

<h3>管理者</h3>

![管理者画面表示](https://user-images.githubusercontent.com/90845405/201485386-4c5fad69-90a9-4732-95ce-4ecfa96101a7.jpg)

<h3>下請け業者</h3>

![下請け画面表示](https://user-images.githubusercontent.com/90845405/201485233-c715fb18-0780-4a4a-a156-1d810e105183.jpg)


## [swaggerによるAPI仕様書](https://tomoroltuto.github.io/Business-management/dist/index.html) 
↑編集中です



# インフラ構成図

![インフラ構造図](https://user-images.githubusercontent.com/90845405/201934728-3c8f8ea7-4b6d-4d90-a89e-aa57415d74e7.jpg)
