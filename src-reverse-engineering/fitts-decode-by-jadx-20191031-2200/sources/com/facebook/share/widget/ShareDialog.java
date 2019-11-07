package com.facebook.share.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.os.EnvironmentCompat;
import androidx.fragment.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.DialogPresenter.ParameterProvider;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeAppCallAttachmentStore.Attachment;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.Sharer.Result;
import com.facebook.share.internal.CameraEffectFeature;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.ShareStoryFeature;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.SharePhotoContent.Builder;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideoContent;
import com.kakao.message.template.MessageTemplateProtocol;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ShareDialog extends FacebookDialogBase<ShareContent, Result> implements Sharer {
    private static final int DEFAULT_REQUEST_CODE = RequestCodeOffset.Share.toRequestCode();
    private static final String TAG = "ShareDialog";
    public static final String WEB_SHARE_DIALOG = "share";
    private boolean isAutomaticMode;
    private boolean shouldFailOnDataError;

    /* renamed from: com.facebook.share.widget.ShareDialog$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$widget$ShareDialog$Mode = new int[Mode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.facebook.share.widget.ShareDialog$Mode[] r0 = com.facebook.share.widget.ShareDialog.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$share$widget$ShareDialog$Mode = r0
                int[] r0 = $SwitchMap$com$facebook$share$widget$ShareDialog$Mode     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.facebook.share.widget.ShareDialog$Mode r1 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$facebook$share$widget$ShareDialog$Mode     // Catch:{ NoSuchFieldError -> 0x001f }
                com.facebook.share.widget.ShareDialog$Mode r1 = com.facebook.share.widget.ShareDialog.Mode.WEB     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$facebook$share$widget$ShareDialog$Mode     // Catch:{ NoSuchFieldError -> 0x002a }
                com.facebook.share.widget.ShareDialog$Mode r1 = com.facebook.share.widget.ShareDialog.Mode.NATIVE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.AnonymousClass1.<clinit>():void");
        }
    }

    private class CameraEffectHandler extends ModeHandler {
        private CameraEffectHandler() {
            super(ShareDialog.this);
        }

        /* synthetic */ CameraEffectHandler(ShareDialog shareDialog, AnonymousClass1 r2) {
            this();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareCameraEffectContent) && ShareDialog.canShowNative(shareContent.getClass());
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider(this) {
                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }

                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }
            }, ShareDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    private class FeedHandler extends ModeHandler {
        private FeedHandler() {
            super(ShareDialog.this);
        }

        /* synthetic */ FeedHandler(ShareDialog shareDialog, AnonymousClass1 r2) {
            this();
        }

        public Object getMode() {
            return Mode.FEED;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareLinkContent) || (shareContent instanceof ShareFeedContent);
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle bundle;
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.FEED);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            if (shareContent instanceof ShareLinkContent) {
                ShareLinkContent shareLinkContent = (ShareLinkContent) shareContent;
                ShareContentValidation.validateForWebShare(shareLinkContent);
                bundle = WebDialogParameters.createForFeed(shareLinkContent);
            } else {
                bundle = WebDialogParameters.createForFeed((ShareFeedContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, MessageTemplateProtocol.TYPE_FEED, bundle);
            return createBaseAppCall;
        }
    }

    public enum Mode {
        AUTOMATIC,
        NATIVE,
        WEB,
        FEED
    }

    private class NativeHandler extends ModeHandler {
        private NativeHandler() {
            super(ShareDialog.this);
        }

        /* synthetic */ NativeHandler(ShareDialog shareDialog, AnonymousClass1 r2) {
            this();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            boolean z2;
            if (shareContent == null || (shareContent instanceof ShareCameraEffectContent) || (shareContent instanceof ShareStoryContent)) {
                return false;
            }
            if (!z) {
                z2 = shareContent.getShareHashtag() != null ? DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG) : true;
                if ((shareContent instanceof ShareLinkContent) && !Utility.isNullOrEmpty(((ShareLinkContent) shareContent).getQuote())) {
                    z2 &= DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                }
            } else {
                z2 = true;
            }
            if (!z2 || !ShareDialog.canShowNative(shareContent.getClass())) {
                return false;
            }
            return true;
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.NATIVE);
            ShareContentValidation.validateForNativeShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider(this) {
                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }

                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }
            }, ShareDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    private class ShareStoryHandler extends ModeHandler {
        private ShareStoryHandler() {
            super(ShareDialog.this);
        }

        /* synthetic */ ShareStoryHandler(ShareDialog shareDialog, AnonymousClass1 r2) {
            this();
        }

        public Object getMode() {
            return Mode.NATIVE;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return (shareContent instanceof ShareStoryContent) && ShareDialog.canShowNative(shareContent.getClass());
        }

        public AppCall createAppCall(final ShareContent shareContent) {
            ShareContentValidation.validateForStoryShare(shareContent);
            final AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            final boolean shouldFailOnDataError = ShareDialog.this.getShouldFailOnDataError();
            DialogPresenter.setupAppCallForNativeDialog(createBaseAppCall, new ParameterProvider(this) {
                public Bundle getParameters() {
                    return NativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }

                public Bundle getLegacyParameters() {
                    return LegacyNativeDialogParameters.create(createBaseAppCall.getCallId(), shareContent, shouldFailOnDataError);
                }
            }, ShareDialog.getFeature(shareContent.getClass()));
            return createBaseAppCall;
        }
    }

    private class WebShareHandler extends ModeHandler {
        private WebShareHandler() {
            super(ShareDialog.this);
        }

        /* synthetic */ WebShareHandler(ShareDialog shareDialog, AnonymousClass1 r2) {
            this();
        }

        public Object getMode() {
            return Mode.WEB;
        }

        public boolean canShow(ShareContent shareContent, boolean z) {
            return shareContent != null && ShareDialog.canShowWebCheck(shareContent);
        }

        public AppCall createAppCall(ShareContent shareContent) {
            Bundle bundle;
            ShareDialog shareDialog = ShareDialog.this;
            shareDialog.logDialogShare(shareDialog.getActivityContext(), shareContent, Mode.WEB);
            AppCall createBaseAppCall = ShareDialog.this.createBaseAppCall();
            ShareContentValidation.validateForWebShare(shareContent);
            if (shareContent instanceof ShareLinkContent) {
                bundle = WebDialogParameters.create((ShareLinkContent) shareContent);
            } else if (shareContent instanceof SharePhotoContent) {
                bundle = WebDialogParameters.create(createAndMapAttachments((SharePhotoContent) shareContent, createBaseAppCall.getCallId()));
            } else {
                bundle = WebDialogParameters.create((ShareOpenGraphContent) shareContent);
            }
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, getActionName(shareContent), bundle);
            return createBaseAppCall;
        }

        private String getActionName(ShareContent shareContent) {
            if ((shareContent instanceof ShareLinkContent) || (shareContent instanceof SharePhotoContent)) {
                return ShareDialog.WEB_SHARE_DIALOG;
            }
            if (shareContent instanceof ShareOpenGraphContent) {
                return "share_open_graph";
            }
            return null;
        }

        private SharePhotoContent createAndMapAttachments(SharePhotoContent sharePhotoContent, UUID uuid) {
            Builder readFrom = new Builder().readFrom(sharePhotoContent);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < sharePhotoContent.getPhotos().size(); i++) {
                SharePhoto sharePhoto = (SharePhoto) sharePhotoContent.getPhotos().get(i);
                Bitmap bitmap = sharePhoto.getBitmap();
                if (bitmap != null) {
                    Attachment createAttachment = NativeAppCallAttachmentStore.createAttachment(uuid, bitmap);
                    sharePhoto = new SharePhoto.Builder().readFrom(sharePhoto).setImageUrl(Uri.parse(createAttachment.getAttachmentUrl())).setBitmap(null).build();
                    arrayList2.add(createAttachment);
                }
                arrayList.add(sharePhoto);
            }
            readFrom.setPhotos(arrayList);
            NativeAppCallAttachmentStore.addAttachments(arrayList2);
            return readFrom.build();
        }
    }

    public static void show(Activity activity, ShareContent shareContent) {
        new ShareDialog(activity).show(shareContent);
    }

    public static void show(Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    public static void show(android.app.Fragment fragment, ShareContent shareContent) {
        show(new FragmentWrapper(fragment), shareContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, ShareContent shareContent) {
        new ShareDialog(fragmentWrapper).show(shareContent);
    }

    public static boolean canShow(Class<? extends ShareContent> cls) {
        return canShowWebTypeCheck(cls) || canShowNative(cls);
    }

    /* access modifiers changed from: private */
    public static boolean canShowNative(Class<? extends ShareContent> cls) {
        DialogFeature feature = getFeature(cls);
        return feature != null && DialogPresenter.canPresentNativeDialogWithFeature(feature);
    }

    private static boolean canShowWebTypeCheck(Class<? extends ShareContent> cls) {
        return ShareLinkContent.class.isAssignableFrom(cls) || ShareOpenGraphContent.class.isAssignableFrom(cls) || (SharePhotoContent.class.isAssignableFrom(cls) && AccessToken.isCurrentAccessTokenActive());
    }

    /* access modifiers changed from: private */
    public static boolean canShowWebCheck(ShareContent shareContent) {
        if (!canShowWebTypeCheck(shareContent.getClass())) {
            return false;
        }
        if (shareContent instanceof ShareOpenGraphContent) {
            try {
                ShareInternalUtility.toJSONObjectForWeb((ShareOpenGraphContent) shareContent);
            } catch (Exception e) {
                Utility.logd(TAG, "canShow returned false because the content of the Opem Graph object can't be shared via the web dialog", e);
                return false;
            }
        }
        return true;
    }

    public ShareDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    public ShareDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public ShareDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private ShareDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
        this.shouldFailOnDataError = false;
        this.isAutomaticMode = true;
        ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, FacebookCallback<Result> facebookCallback) {
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManagerImpl, facebookCallback);
    }

    public boolean getShouldFailOnDataError() {
        return this.shouldFailOnDataError;
    }

    public void setShouldFailOnDataError(boolean z) {
        this.shouldFailOnDataError = z;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.facebook.share.widget.ShareDialog$Mode, code=java.lang.Object, for r3v0, types: [com.facebook.share.widget.ShareDialog$Mode, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canShow(com.facebook.share.model.ShareContent r2, java.lang.Object r3) {
        /*
            r1 = this;
            com.facebook.share.widget.ShareDialog$Mode r0 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC
            if (r3 != r0) goto L_0x0006
            java.lang.Object r3 = com.facebook.internal.FacebookDialogBase.BASE_AUTOMATIC_MODE
        L_0x0006:
            boolean r2 = r1.canShowImpl(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.canShow(com.facebook.share.model.ShareContent, com.facebook.share.widget.ShareDialog$Mode):boolean");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=com.facebook.share.widget.ShareDialog$Mode, code=java.lang.Object, for r3v0, types: [com.facebook.share.widget.ShareDialog$Mode, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void show(com.facebook.share.model.ShareContent r2, java.lang.Object r3) {
        /*
            r1 = this;
            com.facebook.share.widget.ShareDialog$Mode r0 = com.facebook.share.widget.ShareDialog.Mode.AUTOMATIC
            if (r3 != r0) goto L_0x0006
            r0 = 1
            goto L_0x0007
        L_0x0006:
            r0 = 0
        L_0x0007:
            r1.isAutomaticMode = r0
            boolean r0 = r1.isAutomaticMode
            if (r0 == 0) goto L_0x000f
            java.lang.Object r3 = com.facebook.internal.FacebookDialogBase.BASE_AUTOMATIC_MODE
        L_0x000f:
            r1.showImpl(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.share.widget.ShareDialog.show(com.facebook.share.model.ShareContent, com.facebook.share.widget.ShareDialog$Mode):void");
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    /* access modifiers changed from: protected */
    public List<ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NativeHandler(this, null));
        arrayList.add(new FeedHandler(this, null));
        arrayList.add(new WebShareHandler(this, null));
        arrayList.add(new CameraEffectHandler(this, null));
        arrayList.add(new ShareStoryHandler(this, null));
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static DialogFeature getFeature(Class<? extends ShareContent> cls) {
        if (ShareLinkContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.SHARE_DIALOG;
        }
        if (SharePhotoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.PHOTOS;
        }
        if (ShareVideoContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.VIDEO;
        }
        if (ShareOpenGraphContent.class.isAssignableFrom(cls)) {
            return OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
        }
        if (ShareMediaContent.class.isAssignableFrom(cls)) {
            return ShareDialogFeature.MULTIMEDIA;
        }
        if (ShareCameraEffectContent.class.isAssignableFrom(cls)) {
            return CameraEffectFeature.SHARE_CAMERA_EFFECT;
        }
        if (ShareStoryContent.class.isAssignableFrom(cls)) {
            return ShareStoryFeature.SHARE_STORY_ASSET;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void logDialogShare(Context context, ShareContent shareContent, Mode mode) {
        if (this.isAutomaticMode) {
            mode = Mode.AUTOMATIC;
        }
        int i = AnonymousClass1.$SwitchMap$com$facebook$share$widget$ShareDialog$Mode[mode.ordinal()];
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        String str2 = i != 1 ? i != 2 ? i != 3 ? str : "native" : "web" : "automatic";
        DialogFeature feature = getFeature(shareContent.getClass());
        if (feature == ShareDialogFeature.SHARE_DIALOG) {
            str = "status";
        } else if (feature == ShareDialogFeature.PHOTOS) {
            str = "photo";
        } else if (feature == ShareDialogFeature.VIDEO) {
            str = MessengerShareContentUtility.MEDIA_VIDEO;
        } else if (feature == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
            str = MessengerShareContentUtility.TEMPLATE_OPEN_GRAPH_TYPE;
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        String str3 = "fb_share_dialog_show";
        bundle.putString(str3, str2);
        bundle.putString("fb_share_dialog_content_type", str);
        newLogger.logSdkEvent(str3, null, bundle);
    }
}
