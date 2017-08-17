# Koala Native Ad SDK - Maximize the value of your app

## Introduction
Koala Native Ad SDK is powered by [Kika Tech](http://kikatech.com/), one of the most popular keyboard developer around the world.
Our platform focus on the mobile native advertising, and we have:
> **1.Campaigns from 200+ regions & 95%+ fill-rate**<br/>
> **2.Massive advertising behavior data**<br/>
> **3.Global reach with direct advertisers(CPI/CPC/CPM)**<br/>
> **4.Rich of users profiles and their label of interests**<br/>
> **5.High accuracy of ad serving**<br/>

## Account
Please contact with our AM for account.

## Terms
#### 1.oid
Like ad placement id on Facebook Audience Network, an oid always contains characters(a-z, A-Z), digits(0-9) and '_'.
> **VALID OID examples**:
- home_native
- icon03
- splashAd

> **INVALID OID examples**:
- native#ad
- home page native ad

#### 2.app_key
Identifier for your app on our Koala Ad Platform.

## SDK Usage
### 1.Preparation
Our SDK need accees the network for ad requests, so you should make sure you have already add these permissions in `AndroidManifest.xml`:

```java
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```

And you should put the APP_KEY and SECRET_KEY in `AndroidManifest.xml` as below:

```java
<meta-data
    android:name="AD_AGENT_APPKEY"
    android:value="{YOUR APP_KEY HERE}" />
<meta-data
    android:name="AD_AGENT_SECRET"
    android:value="{YOUR SECRET_KEY HERE}" />
```

For ad recommend, you should add `KoalaAppInstallReceiver` in `AndroidManifest.xml`:

```java
<receiver android:name="com.kika.pluto.filter.KoalaAppInstallReceiver" >
    <intent-filter>
        <action android:name="android.intent.action.PACKAGE_ADDED" />
        <action android:name="android.intent.action.PACKAGE_REMOVED" />
        <data android:scheme="package" />
    </intent-filter>
</receiver>
```

### 2.Initial SDK
Before you load ad, you should initial Koala Native Ad SDK first:


```java
KoalaADAgent.init(Context context);
```

**Note:** We recommend you initial our SDK when the application start, and you don't have to repeat the initial action during the application lifecycle.

### 3.Request Native Ad
We offer you class `ADFactory.ADRequestSetting` for ad request settings, you can set your own specialized parameters for the
ad request, like oid, icon size, creative size.

```java
ADFactory.ADRequestSetting adRequestSetting = ADFactory.getADRequestSetting({YOUR AD OID})
                .setImageSize(KoalaConstants.AD_IMAGE_1200x628);
```

Then you can request ad with method `loadAd()` like:

```java
KoalaADAgent.loadAd(adRequestSetting, new NativeAdListener.RequestAdListener() {
    @Override
    public void onSuccess(final NativeAd nativeAd) {
        // put your code here
        Toast.makeText(NativeAdActivity.this, "ad load succeed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String errorMsg, int errorCode) {
        // put your code here
        Toast.makeText(NativeAdActivity.this, "ad load failed", Toast.LENGTH_SHORT).show();
    }
});
```

#### NativeAd
Class `NativeAd` fields:
> **title**: String, ad title<br/>
> **description**: String, ad description<br/>
> **rate**: String, for example, 4.4, the value should between 0 and 5<br/>
> **creative**: Map, the key is the size of creative, and the value is its url<br/>
> **callToAction**: String, call to action<br/>

#### Error Code
Sometimes, you may get no ads, and you may get error code below:
> **1001**: no fill, mostly because of the invalid appkey or the poor network<br/>
> **1004**: oid is empty<br/>
> **1019**: SDK not initialized yet<br/>
> **1024**: request too frequent with the same oid<br/>

### 4.Show Native Ad
Register ad view when the ad is present on the user screen.

```java
KoalaADAgent.registerNativeAdView(mNativeAd, mAdView, new NativeAdListener.NativeAdClickedListener() {
    @Override
    public void onAdClicked(String s) {
        Toast.makeText(NativeAdActivity.this, "ad clicked, please wait", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdOpened(String s) {
        Toast.makeText(NativeAdActivity.this, "ad opened", Toast.LENGTH_SHORT).show();
    }
});
```

### 5.Destroy Ad
If you don't want to show an ad, you should unregister the ad view with `KoalaADAgent.unregisterNativeAdView(NativeAd nativeAd)`.<br/>
And you should destroy the ad with `KoalaADAgent.destroyNativeAd(NativeAd nativeAd)` if you don't need it anymore.

### 6.App Wall
(*NOTE*: Please make sure you have already finish the Step 1 and Step 2.)<br/><br/>
It's very easy for you to add app wall in your app, the only thing you have to do is start our app wall activity:`KoalaAppWallActivity`:
```java
intent = new Intent(MainActivity.this, KoalaAppWallActivity.class);
startActivity(intent);
```
and declare it in `AndroidManifest.xml`:
```java
<activity android:name="com.kika.pluto.appwall.KoalaAppWallActivity"
            android:theme="@android:style/Theme.NoTitleBar"/>
```
*NOTE*: Please make sure you have already finish the Step 1 and Step 2.

## More
Learn more about our platform?  Please visit [Acekoala Platform](http://www.acekoala.com/).<br/>
Any advice for us?  Please send mail to [operating@kikatech.com](operating@kikatech.com)

