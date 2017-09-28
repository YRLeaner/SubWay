package com.example.tyr.subway3.beans;


        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

        import org.w3c.dom.ls.LSResourceResolver;

        import java.io.Serializable;
        import java.util.List;

/**
 * Created by tyr on 2017/8/18.
 */
public class DuanZiBean implements Serializable {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public static class Activity {

    }

    public static class Comment implements Serializable  {

        @SerializedName("text")
        @Expose
        private String text;
       /* @SerializedName("create_time")
        @Expose
        private String createTime;
        @SerializedName("user_verified")
        @Expose
        private String userVerified;
        @SerializedName("user_bury")
        @Expose
        private String userBury;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("bury_count")
        @Expose
        private String buryCount;
        @SerializedName("share_url")
        @Expose
        private String shareUrl;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("platform")
        @Expose
        private String platform;
        @SerializedName("is_digg")
        @Expose
        private String isDigg;
        @SerializedName("user_name")
        @Expose
        private String userName;
        @SerializedName("user_profile_image_url")
        @Expose
        private String userProfileImageUrl;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("user_digg")
        @Expose
        private String userDigg;
        @SerializedName("user_profile_url")
        @Expose
        private String userProfileUrl;
        @SerializedName("share_type")
        @Expose
        private String shareType;
        @SerializedName("digg_count")
        @Expose
        private String diggCount;
        @SerializedName("is_pro_user")
        @Expose
        private String isProUser;
        @SerializedName("platform_id")
        @Expose
        private String platformId;
        @SerializedName("avatar_url")
        @Expose
        private String avatarUrl;
        @SerializedName("group_id")
        @Expose
        private String groupId;
*/
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

       /* public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUserVerified() {
            return userVerified;
        }

        public void setUserVerified(String userVerified) {
            this.userVerified = userVerified;
        }

        public String getUserBury() {
            return userBury;
        }

        public void setUserBury(String userBury) {
            this.userBury = userBury;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getBuryCount() {
            return buryCount;
        }

        public void setBuryCount(String buryCount) {
            this.buryCount = buryCount;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getIsDigg() {
            return isDigg;
        }

        public void setIsDigg(String isDigg) {
            this.isDigg = isDigg;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserProfileImageUrl() {
            return userProfileImageUrl;
        }

        public void setUserProfileImageUrl(String userProfileImageUrl) {
            this.userProfileImageUrl = userProfileImageUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUserDigg() {
            return userDigg;
        }

        public void setUserDigg(String userDigg) {
            this.userDigg = userDigg;
        }

        public String getUserProfileUrl() {
            return userProfileUrl;
        }

        public void setUserProfileUrl(String userProfileUrl) {
            this.userProfileUrl = userProfileUrl;
        }

        public String getShareType() {
            return shareType;
        }

        public void setShareType(String shareType) {
            this.shareType = shareType;
        }

        public String getDiggCount() {
            return diggCount;
        }

        public void setDiggCount(String diggCount) {
            this.diggCount = diggCount;
        }

        public String getIsProUser() {
            return isProUser;
        }

        public void setIsProUser(String isProUser) {
            this.isProUser = isProUser;
        }

        public String getPlatformId() {
            return platformId;
        }

        public void setPlatformId(String platformId) {
            this.platformId = platformId;
        }

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }*/
    }

    public static class Data {

        @SerializedName("has_more")
        @Expose
        private String hasMore;
        @SerializedName("tip")
        @Expose
        private String tip;
        @SerializedName("has_new_message")
        @Expose
        private String hasNewMessage;
        @SerializedName("max_time")
        @Expose
        private String maxTime;
        @SerializedName("min_time")
        @Expose
        private String minTime;
        @SerializedName("data")
        @Expose
        private List<Datum> data = null;

        public String getHasMore() {
            return hasMore;
        }

        public void setHasMore(String hasMore) {
            this.hasMore = hasMore;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public String getHasNewMessage() {
            return hasNewMessage;
        }

        public void setHasNewMessage(String hasNewMessage) {
            this.hasNewMessage = hasNewMessage;
        }

        public String getMaxTime() {
            return maxTime;
        }

        public void setMaxTime(String maxTime) {
            this.maxTime = maxTime;
        }

        public String getMinTime() {
            return minTime;
        }

        public void setMinTime(String minTime) {
            this.minTime = minTime;
        }

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }

    }

    public static class Datum implements Serializable{

        @SerializedName("group")
        @Expose
        private Group group;
        @SerializedName("comments")
        @Expose
        private List<Comment> comments = null;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("display_time")
        @Expose
        private String displayTime;
        @SerializedName("online_time")
        @Expose
        private String onlineTime;
        @SerializedName("ad")
        @Expose
        private Ad ad;

        public Ad getAd() {
            return ad;
        }

        public void setAd(Ad ad) {
            this.ad = ad;
        }

        public Group getGroup() {
            return group;
        }

        public void setGroup(Group group) {
            this.group = group;
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDisplayTime() {
            return displayTime;
        }

        public void setDisplayTime(String displayTime) {
            this.displayTime = displayTime;
        }

        public String getOnlineTime() {
            return onlineTime;
        }

        public void setOnlineTime(String onlineTime) {
            this.onlineTime = onlineTime;
        }

    }

  /*  public class DislikeReason {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
*/
  public static class Ad implements Serializable {

   /*   @SerializedName("log_extra")
      @Expose
      private LogExtra logExtra;*/
   /*   @SerializedName("open_url")
      @Expose
      private String openUrl;
      @SerializedName("track_url")
      @Expose
      private String trackUrl;
      @SerializedName("display_info")
      @Expose
      private String displayInfo;
      @SerializedName("web_url")
      @Expose
      private String webUrl;
      @SerializedName("appleid")
      @Expose
      private String appleid;
      @SerializedName("id")
      @Expose
      private Integer id;
      @SerializedName("display_image_height")
      @Expose
      private Integer displayImageHeight;
      @SerializedName("display_image_width")
      @Expose
      private Integer displayImageWidth;
      @SerializedName("title")
      @Expose
      private String title;
      @SerializedName("download_url")
      @Expose
      private String downloadUrl;
      @SerializedName("label")
      @Expose
      private String label;
      @SerializedName("source")
      @Expose
      private String source;
      @SerializedName("track_url_list")
      @Expose
      private List<Object> trackUrlList = null;
      @SerializedName("display_image")
      @Expose
      private String displayImage;
      @SerializedName("filter_words")
      @Expose
      private List<FilterWord> filterWords = null;
      @SerializedName("avatar_name")
      @Expose
      private String avatarName;
      @SerializedName("type")
      @Expose
      private String type;
      @SerializedName("is_ad")
      @Expose
      private Integer isAd;
      @SerializedName("end_time")
      @Expose
      private Integer endTime;
      @SerializedName("gif_url")
      @Expose
      private String gifUrl;
      @SerializedName("ad_id")
      @Expose
      private Integer adId;
      @SerializedName("button_text")
      @Expose
      private String buttonText;
      @SerializedName("display_type")
      @Expose
      private Integer displayType;
      @SerializedName("click_delay")
      @Expose
      private Integer clickDelay;
      @SerializedName("ab_show_style")
      @Expose
      private Integer abShowStyle;
      @SerializedName("package")
      @Expose
      private String _package;
      @SerializedName("hide_if_exists")
      @Expose
      private Integer hideIfExists;
      @SerializedName("avatar_url")
      @Expose
      private String avatarUrl;
      @SerializedName("ipa_url")
      @Expose
      private String ipaUrl;

      public LogExtra getLogExtra() {
          return logExtra;
      }

      public void setLogExtra(LogExtra logExtra) {
          this.logExtra = logExtra;
      }

      public String getOpenUrl() {
          return openUrl;
      }

      public void setOpenUrl(String openUrl) {
          this.openUrl = openUrl;
      }

      public String getTrackUrl() {
          return trackUrl;
      }

      public void setTrackUrl(String trackUrl) {
          this.trackUrl = trackUrl;
      }

      public String getDisplayInfo() {
          return displayInfo;
      }

      public void setDisplayInfo(String displayInfo) {
          this.displayInfo = displayInfo;
      }

      public String getWebUrl() {
          return webUrl;
      }

      public void setWebUrl(String webUrl) {
          this.webUrl = webUrl;
      }

      public String getAppleid() {
          return appleid;
      }

      public void setAppleid(String appleid) {
          this.appleid = appleid;
      }

      public Integer getId() {
          return id;
      }

      public void setId(Integer id) {
          this.id = id;
      }

      public Integer getDisplayImageHeight() {
          return displayImageHeight;
      }

      public void setDisplayImageHeight(Integer displayImageHeight) {
          this.displayImageHeight = displayImageHeight;
      }

      public Integer getDisplayImageWidth() {
          return displayImageWidth;
      }

      public void setDisplayImageWidth(Integer displayImageWidth) {
          this.displayImageWidth = displayImageWidth;
      }

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }

      public String getDownloadUrl() {
          return downloadUrl;
      }

      public void setDownloadUrl(String downloadUrl) {
          this.downloadUrl = downloadUrl;
      }

      public String getLabel() {
          return label;
      }

      public void setLabel(String label) {
          this.label = label;
      }

      public String getSource() {
          return source;
      }

      public void setSource(String source) {
          this.source = source;
      }

      public List<Object> getTrackUrlList() {
          return trackUrlList;
      }

      public void setTrackUrlList(List<Object> trackUrlList) {
          this.trackUrlList = trackUrlList;
      }

      public String getDisplayImage() {
          return displayImage;
      }

      public void setDisplayImage(String displayImage) {
          this.displayImage = displayImage;
      }

      public List<FilterWord> getFilterWords() {
          return filterWords;
      }

      public void setFilterWords(List<FilterWord> filterWords) {
          this.filterWords = filterWords;
      }

      public String getAvatarName() {
          return avatarName;
      }

      public void setAvatarName(String avatarName) {
          this.avatarName = avatarName;
      }

      public String getType() {
          return type;
      }

      public void setType(String type) {
          this.type = type;
      }

      public Integer getIsAd() {
          return isAd;
      }

      public void setIsAd(Integer isAd) {
          this.isAd = isAd;
      }

      public Integer getEndTime() {
          return endTime;
      }

      public void setEndTime(Integer endTime) {
          this.endTime = endTime;
      }

      public String getGifUrl() {
          return gifUrl;
      }

      public void setGifUrl(String gifUrl) {
          this.gifUrl = gifUrl;
      }

      public Integer getAdId() {
          return adId;
      }

      public void setAdId(Integer adId) {
          this.adId = adId;
      }

      public String getButtonText() {
          return buttonText;
      }

      public void setButtonText(String buttonText) {
          this.buttonText = buttonText;
      }

      public Integer getDisplayType() {
          return displayType;
      }

      public void setDisplayType(Integer displayType) {
          this.displayType = displayType;
      }

      public Integer getClickDelay() {
          return clickDelay;
      }

      public void setClickDelay(Integer clickDelay) {
          this.clickDelay = clickDelay;
      }

      public Integer getAbShowStyle() {
          return abShowStyle;
      }

      public void setAbShowStyle(Integer abShowStyle) {
          this.abShowStyle = abShowStyle;
      }

      public String getPackage() {
          return _package;
      }

      public void setPackage(String _package) {
          this._package = _package;
      }

      public Integer getHideIfExists() {
          return hideIfExists;
      }

      public void setHideIfExists(Integer hideIfExists) {
          this.hideIfExists = hideIfExists;
      }

      public String getAvatarUrl() {
          return avatarUrl;
      }

      public void setAvatarUrl(String avatarUrl) {
          this.avatarUrl = avatarUrl;
      }

      public String getIpaUrl() {
          return ipaUrl;
      }

      public void setIpaUrl(String ipaUrl) {
          this.ipaUrl = ipaUrl;
      }*/

  }

    public class Group implements Serializable{

        @SerializedName("text")
        @Expose
        private String text;
       /* @SerializedName("neihan_hot_start_time")
        @Expose
        private String neihanHotStartTime;
        @SerializedName("dislike_reason")
        @Expose
        private List<DislikeReason> dislikeReason = null;
        @SerializedName("create_time")
        @Expose
        private String createTime;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("favorite_count")
        @Expose
        private String favoriteCount;
        @SerializedName("go_detail_count")
        @Expose
        private String goDetailCount;
        @SerializedName("user_favorite")
        @Expose
        private String userFavorite;
        @SerializedName("share_type")
        @Expose
        private String shareType;*/
        @SerializedName("user")
        @Expose
        private User user;
        /*@SerializedName("is_can_share")
        @Expose
        private String isCanShare;
        @SerializedName("category_type")
        @Expose
        private String categoryType;
        @SerializedName("share_url")
        @Expose
        private String shareUrl;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("comment_count")
        @Expose
        private String commentCount;
        @SerializedName("id_str")
        @Expose
        private String idStr;
        @SerializedName("media_type")
        @Expose
        private String mediaType;
        @SerializedName("share_count")
        @Expose
        private String shareCount;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("has_comments")
        @Expose
        private String hasComments;
        @SerializedName("user_bury")
        @Expose
        private String userBury;
        @SerializedName("activity")
        @Expose
        private Activity activity;
        @SerializedName("status_desc")
        @Expose
        private String statusDesc;
        @SerializedName("quick_comment")
        @Expose
        private Boolean quickComment;
        @SerializedName("display_type")
        @Expose
        private String displayType;
        @SerializedName("neihan_hot_end_time")
        @Expose
        private String neihanHotEndTime;
        @SerializedName("is_personal_show")
        @Expose
        private Boolean isPersonalShow;
        @SerializedName("user_digg")
        @Expose
        private String userDigg;
        @SerializedName("online_time")
        @Expose
        private String onlineTime;
        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_visible")
        @Expose
        private Boolean categoryVisible;
        @SerializedName("bury_count")
        @Expose
        private String buryCount;
        @SerializedName("is_anonymous")
        @Expose
        private Boolean isAnonymous;
        @SerializedName("repin_count")
        @Expose
        private String repinCount;
        @SerializedName("is_neihan_hot")
        @Expose
        private Boolean isNeihanHot;
        @SerializedName("digg_count")
        @Expose
        private String diggCount;
        @SerializedName("has_hot_comments")
        @Expose
        private String hasHotComments;
        @SerializedName("allow_dislike")
        @Expose
        private Boolean allowDislike;
        @SerializedName("user_repin")
        @Expose
        private String userRepin;
        @SerializedName("neihan_hot_link")
        @Expose
        private NeihanHotLink neihanHotLink;
        @SerializedName("group_id")
        @Expose
        private String groupId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;*/

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
        /*
        public String getNeihanHotStartTime() {
            return neihanHotStartTime;
        }

        public void setNeihanHotStartTime(String neihanHotStartTime) {
            this.neihanHotStartTime = neihanHotStartTime;
        }

        public List<DislikeReason> getDislikeReason() {
            return dislikeReason;
        }

        public void setDislikeReason(List<DislikeReason> dislikeReason) {
            this.dislikeReason = dislikeReason;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(String favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public String getGoDetailCount() {
            return goDetailCount;
        }

        public void setGoDetailCount(String goDetailCount) {
            this.goDetailCount = goDetailCount;
        }

        public String getUserFavorite() {
            return userFavorite;
        }

        public void setUserFavorite(String userFavorite) {
            this.userFavorite = userFavorite;
        }

        public String getShareType() {
            return shareType;
        }

        public void setShareType(String shareType) {
            this.shareType = shareType;
        }

     */   public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }/*

        public String getIsCanShare() {
            return isCanShare;
        }

        public void setIsCanShare(String isCanShare) {
            this.isCanShare = isCanShare;
        }

        public String getCategoryType() {
            return categoryType;
        }

        public void setCategoryType(String categoryType) {
            this.categoryType = categoryType;
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public String getIdStr() {
            return idStr;
        }

        public void setIdStr(String idStr) {
            this.idStr = idStr;
        }

        public String getMediaType() {
            return mediaType;
        }

        public void setMediaType(String mediaType) {
            this.mediaType = mediaType;
        }

        public String getShareCount() {
            return shareCount;
        }

        public void setShareCount(String shareCount) {
            this.shareCount = shareCount;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getHasComments() {
            return hasComments;
        }

        public void setHasComments(String hasComments) {
            this.hasComments = hasComments;
        }

        public String getUserBury() {
            return userBury;
        }

        public void setUserBury(String userBury) {
            this.userBury = userBury;
        }

        public Activity getActivity() {
            return activity;
        }

        public void setActivity(Activity activity) {
            this.activity = activity;
        }

        public String getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(String statusDesc) {
            this.statusDesc = statusDesc;
        }

        public Boolean getQuickComment() {
            return quickComment;
        }

        public void setQuickComment(Boolean quickComment) {
            this.quickComment = quickComment;
        }

        public String getDisplayType() {
            return displayType;
        }

        public void setDisplayType(String displayType) {
            this.displayType = displayType;
        }

        public String getNeihanHotEndTime() {
            return neihanHotEndTime;
        }

        public void setNeihanHotEndTime(String neihanHotEndTime) {
            this.neihanHotEndTime = neihanHotEndTime;
        }

        public Boolean getIsPersonalShow() {
            return isPersonalShow;
        }

        public void setIsPersonalShow(Boolean isPersonalShow) {
            this.isPersonalShow = isPersonalShow;
        }

        public String getUserDigg() {
            return userDigg;
        }

        public void setUserDigg(String userDigg) {
            this.userDigg = userDigg;
        }

        public String getOnlineTime() {
            return onlineTime;
        }

        public void setOnlineTime(String onlineTime) {
            this.onlineTime = onlineTime;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Boolean getCategoryVisible() {
            return categoryVisible;
        }

        public void setCategoryVisible(Boolean categoryVisible) {
            this.categoryVisible = categoryVisible;
        }

        public String getBuryCount() {
            return buryCount;
        }

        public void setBuryCount(String buryCount) {
            this.buryCount = buryCount;
        }

        public Boolean getIsAnonymous() {
            return isAnonymous;
        }

        public void setIsAnonymous(Boolean isAnonymous) {
            this.isAnonymous = isAnonymous;
        }

        public String getRepinCount() {
            return repinCount;
        }

        public void setRepinCount(String repinCount) {
            this.repinCount = repinCount;
        }

        public Boolean getIsNeihanHot() {
            return isNeihanHot;
        }

        public void setIsNeihanHot(Boolean isNeihanHot) {
            this.isNeihanHot = isNeihanHot;
        }

        public String getDiggCount() {
            return diggCount;
        }

        public void setDiggCount(String diggCount) {
            this.diggCount = diggCount;
        }

        public String getHasHotComments() {
            return hasHotComments;
        }

        public void setHasHotComments(String hasHotComments) {
            this.hasHotComments = hasHotComments;
        }

        public Boolean getAllowDislike() {
            return allowDislike;
        }

        public void setAllowDislike(Boolean allowDislike) {
            this.allowDislike = allowDislike;
        }

        public String getUserRepin() {
            return userRepin;
        }

        public void setUserRepin(String userRepin) {
            this.userRepin = userRepin;
        }

        public NeihanHotLink getNeihanHotLink() {
            return neihanHotLink;
        }

        public void setNeihanHotLink(NeihanHotLink neihanHotLink) {
            this.neihanHotLink = neihanHotLink;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }*/
    }


    public class NeihanHotLink {


    }

    public class User implements Serializable{

        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("name")
        @Expose
        private String name;
       /* @SerializedName("followings")
        @Expose
        private String followings;
        @SerializedName("user_verified")
        @Expose
        private Boolean userVerified;
        @SerializedName("ugc_count")
        @Expose
        private String ugcCount;*/
        @SerializedName("avatar_url")
        @Expose
        private String avatarUrl;
       /* @SerializedName("followers")
        @Expose
        private String followers;
        @SerializedName("is_following")
        @Expose
        private Boolean isFollowing;
        @SerializedName("is_pro_user")
        @Expose
        private Boolean isProUser;*/
/*
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }*/

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

      /*  public String getFollowings() {
            return followings;
        }

        public void setFollowings(String followings) {
            this.followings = followings;
        }

        public Boolean getUserVerified() {
            return userVerified;
        }

        public void setUserVerified(Boolean userVerified) {
            this.userVerified = userVerified;
        }

        public String getUgcCount() {
            return ugcCount;
        }

        public void setUgcCount(String ugcCount) {
            this.ugcCount = ugcCount;
        }
         */
        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        /*
        public String getFollowers() {
            return followers;
        }

        public void setFollowers(String followers) {
            this.followers = followers;
        }

        public Boolean getIsFollowing() {
            return isFollowing;
        }

        public void setIsFollowing(Boolean isFollowing) {
            this.isFollowing = isFollowing;
        }

        public Boolean getIsProUser() {
            return isProUser;
        }

        public void setIsProUser(Boolean isProUser) {
            this.isProUser = isProUser;
        }*/

    }
}
