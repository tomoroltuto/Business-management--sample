# Business-management-application
業務管理アプリケーション

# 概要
下請業者との業務内容を共有する為の管理システム

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

# 設計書

<h2>ER図</h2>

![ER図](https://user-images.githubusercontent.com/90845405/199502850-c678499e-df3e-43a4-bbf2-aa97e562b2cc.jpg)

<h2>URL</h2>

![URL](https://user-images.githubusercontent.com/90845405/199502933-42814bc8-f5d0-403e-9e50-e3a283ff1b2f.jpg)


# [API仕様書](https://tomoroltuto.github.io/Business-management/dist/index.html) 

# インフラ構成図

![インフラ構造図](https://user-images.githubusercontent.com/90845405/199517942-1ded7b5b-f4ba-4167-9397-24f2c8f72866.jpg)
