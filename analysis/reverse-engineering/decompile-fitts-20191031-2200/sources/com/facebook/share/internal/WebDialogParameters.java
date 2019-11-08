package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.Mapper;
import com.facebook.share.model.AppGroupCreationContent;
import com.facebook.share.model.AppGroupCreationContent.AppGroupPrivacy;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.kakao.message.template.MessageTemplateProtocol;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class WebDialogParameters {
    public static Bundle create(AppGroupCreationContent appGroupCreationContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", appGroupCreationContent.getName());
        Utility.putNonEmptyString(bundle, MessageTemplateProtocol.DESCRIPTION, appGroupCreationContent.getDescription());
        AppGroupPrivacy appGroupPrivacy = appGroupCreationContent.getAppGroupPrivacy();
        if (appGroupPrivacy != null) {
            Utility.putNonEmptyString(bundle, "privacy", appGroupPrivacy.toString().toLowerCase(Locale.ENGLISH));
        }
        return bundle;
    }

    public static Bundle create(GameRequestContent gameRequestContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, SettingsJsonConstants.PROMPT_MESSAGE_KEY, gameRequestContent.getMessage());
        Utility.putCommaSeparatedStringList(bundle, "to", gameRequestContent.getRecipients());
        Utility.putNonEmptyString(bundle, "title", gameRequestContent.getTitle());
        Utility.putNonEmptyString(bundle, "data", gameRequestContent.getData());
        if (gameRequestContent.getActionType() != null) {
            Utility.putNonEmptyString(bundle, "action_type", gameRequestContent.getActionType().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putNonEmptyString(bundle, "object_id", gameRequestContent.getObjectId());
        if (gameRequestContent.getFilters() != null) {
            Utility.putNonEmptyString(bundle, "filters", gameRequestContent.getFilters().toString().toLowerCase(Locale.ENGLISH));
        }
        Utility.putCommaSeparatedStringList(bundle, "suggestions", gameRequestContent.getSuggestions());
        return bundle;
    }

    public static Bundle create(ShareLinkContent shareLinkContent) {
        Bundle createBaseParameters = createBaseParameters(shareLinkContent);
        Utility.putUri(createBaseParameters, "href", shareLinkContent.getContentUrl());
        Utility.putNonEmptyString(createBaseParameters, "quote", shareLinkContent.getQuote());
        return createBaseParameters;
    }

    public static Bundle create(ShareOpenGraphContent shareOpenGraphContent) {
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent);
        Utility.putNonEmptyString(createBaseParameters, "action_type", shareOpenGraphContent.getAction().getActionType());
        try {
            JSONObject removeNamespacesFromOGJsonObject = ShareInternalUtility.removeNamespacesFromOGJsonObject(ShareInternalUtility.toJSONObjectForWeb(shareOpenGraphContent), false);
            if (removeNamespacesFromOGJsonObject != null) {
                Utility.putNonEmptyString(createBaseParameters, "action_properties", removeNamespacesFromOGJsonObject.toString());
            }
            return createBaseParameters;
        } catch (JSONException e) {
            throw new FacebookException("Unable to serialize the ShareOpenGraphContent to JSON", (Throwable) e);
        }
    }

    public static Bundle create(SharePhotoContent sharePhotoContent) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent);
        String[] strArr = new String[sharePhotoContent.getPhotos().size()];
        Utility.map(sharePhotoContent.getPhotos(), new Mapper<SharePhoto, String>() {
            public String apply(SharePhoto sharePhoto) {
                return sharePhoto.getImageUrl().toString();
            }
        }).toArray(strArr);
        createBaseParameters.putStringArray(MessengerShareContentUtility.TEMPLATE_MEDIA_TYPE, strArr);
        return createBaseParameters;
    }

    public static Bundle createBaseParameters(ShareContent shareContent) {
        Bundle bundle = new Bundle();
        ShareHashtag shareHashtag = shareContent.getShareHashtag();
        if (shareHashtag != null) {
            Utility.putNonEmptyString(bundle, "hashtag", shareHashtag.getHashtag());
        }
        return bundle;
    }

    public static Bundle createForFeed(ShareLinkContent shareLinkContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "name", shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(bundle, MessageTemplateProtocol.DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putNonEmptyString(bundle, MessageTemplateProtocol.LINK, Utility.getUriString(shareLinkContent.getContentUrl()));
        Utility.putNonEmptyString(bundle, "picture", Utility.getUriString(shareLinkContent.getImageUrl()));
        Utility.putNonEmptyString(bundle, "quote", shareLinkContent.getQuote());
        if (shareLinkContent.getShareHashtag() != null) {
            Utility.putNonEmptyString(bundle, "hashtag", shareLinkContent.getShareHashtag().getHashtag());
        }
        return bundle;
    }

    public static Bundle createForFeed(ShareFeedContent shareFeedContent) {
        Bundle bundle = new Bundle();
        Utility.putNonEmptyString(bundle, "to", shareFeedContent.getToId());
        Utility.putNonEmptyString(bundle, MessageTemplateProtocol.LINK, shareFeedContent.getLink());
        Utility.putNonEmptyString(bundle, "picture", shareFeedContent.getPicture());
        Utility.putNonEmptyString(bundle, "source", shareFeedContent.getMediaSource());
        Utility.putNonEmptyString(bundle, "name", shareFeedContent.getLinkName());
        Utility.putNonEmptyString(bundle, "caption", shareFeedContent.getLinkCaption());
        Utility.putNonEmptyString(bundle, MessageTemplateProtocol.DESCRIPTION, shareFeedContent.getLinkDescription());
        return bundle;
    }
}
