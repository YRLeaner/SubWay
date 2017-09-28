package com.example.tyr.subway3.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by tyr on 2017/8/16.
 */
public class VideoRoot {

    private List<ItemList> itemList;
    private String count;
    private String total;
    private String nextPageUrl;
    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }
    public List<ItemList> getItemList() {
        return itemList;
    }

    public void setCount(String count) {
        this.count = count;
    }
    public String getCount() {
        return count;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    public String getTotal() {
        return total;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }
    public String getNextPageUrl() {
        return nextPageUrl;
    }


    public static class Provider {

        private String name;
        private String alias;
        private String icon;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
        public String getAlias() {
            return alias;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
        public String getIcon() {
            return icon;
        }

    }


    public static class Follow {

        private String itemType;
        private String itemId;
        private boolean followed;
        public void setItemType(String itemType) {
            this.itemType = itemType;
        }
        public String getItemType() {
            return itemType;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }
        public String getItemId() {
            return itemId;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }
        public boolean getFollowed() {
            return followed;
        }

    }


    public static class Shield {

        private String itemType;
        private String itemId;
        private boolean shielded;
        public void setItemType(String itemType) {
            this.itemType = itemType;
        }
        public String getItemType() {
            return itemType;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }
        public String getItemId() {
            return itemId;
        }

        public void setShielded(boolean shielded) {
            this.shielded = shielded;
        }
        public boolean getShielded() {
            return shielded;
        }

    }


    public static class Author {

        private String id;
        private String icon;
        private String name;
        private String description;
        private String link;
        private String latestReleaseTime;
        private String videoNum;
        private String adTrack;
        private Follow follow;
        private Shield shield;
        private int approvedNotReadyVideoCount;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
        public String getIcon() {
            return icon;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }

        public void setLink(String link) {
            this.link = link;
        }
        public String getLink() {
            return link;
        }

        public void setLatestReleaseTime(String latestReleaseTime) {
            this.latestReleaseTime = latestReleaseTime;
        }
        public String getLatestReleaseTime() {
            return latestReleaseTime;
        }

        public void setVideoNum(String videoNum) {
            this.videoNum = videoNum;
        }
        public String getVideoNum() {
            return videoNum;
        }

        public void setAdTrack(String adTrack) {
            this.adTrack = adTrack;
        }
        public String getAdTrack() {
            return adTrack;
        }

        public void setFollow(Follow follow) {
            this.follow = follow;
        }
        public Follow getFollow() {
            return follow;
        }

        public void setShield(Shield shield) {
            this.shield = shield;
        }
        public Shield getShield() {
            return shield;
        }

        public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
            this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
        }
        public int getApprovedNotReadyVideoCount() {
            return approvedNotReadyVideoCount;
        }

    }


    public static class Cover {

        private String feed;
        private String detail;
        private String blurred;
        private String sharing;
        private String homepage;
        public void setFeed(String feed) {
            this.feed = feed;
        }
        public String getFeed() {
            return feed;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
        public String getDetail() {
            return detail;
        }

        public void setBlurred(String blurred) {
            this.blurred = blurred;
        }
        public String getBlurred() {
            return blurred;
        }

        public void setSharing(String sharing) {
            this.sharing = sharing;
        }
        public String getSharing() {
            return sharing;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }
        public String getHomepage() {
            return homepage;
        }

    }


    public static class WebUrl {

        private String raw;
        private String forWeibo;
        public void setRaw(String raw) {
            this.raw = raw;
        }
        public String getRaw() {
            return raw;
        }

        public void setForWeibo(String forWeibo) {
            this.forWeibo = forWeibo;
        }
        public String getForWeibo() {
            return forWeibo;
        }

    }

    public static class UrlList {

        private String name;
        private String url;
        private String size;
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

        public void setSize(String size) {
            this.size = size;
        }
        public String getSize() {
            return size;
        }

    }

    public static class PlayInfo {

        private String height;
        private String width;
        private List<UrlList> urlList;
        private String name;
        private String type;
        private String url;
        public void setHeight(String height) {
            this.height = height;
        }
        public String getHeight() {
            return height;
        }

        public void setWidth(String width) {
            this.width = width;
        }
        public String getWidth() {
            return width;
        }

        public void setUrlList(List<UrlList> urlList) {
            this.urlList = urlList;
        }
        public List<UrlList> getUrlList() {
            return urlList;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

    }

    public static class Consumption {

        private String collectionCount;
        private String shareCount;
        private String replyCount;
        public void setCollectionCount(String collectionCount) {
            this.collectionCount = collectionCount;
        }
        public String getCollectionCount() {
            return collectionCount;
        }

        public void setShareCount(String shareCount) {
            this.shareCount = shareCount;
        }
        public String getShareCount() {
            return shareCount;
        }

        public void setReplyCount(String replyCount) {
            this.replyCount = replyCount;
        }
        public String getReplyCount() {
            return replyCount;
        }

    }


    public static class Data {

        private String dataType;
        private String id;
        private String title;
        private String slogan;
        private String description;
        private Provider provider;
        private String category;
        private Author author;
        private Cover cover;
        private String playUrl;
        private String thumbPlayUrl;
        private String duration;
        private WebUrl webUrl;
        private String releaseTime;
        private String library;
        private List<PlayInfo> playInfo;
        private Consumption consumption;
        private String campaign;
        private String waterMarks;
        private String adTrack;
        private List<Tags> tags;
        private String type;
        private String titlePgc;
        private String descriptionPgc;
        private String remark;
        private String idx;
        private String shareAdTrack;
        private String favoriteAdTrack;
        private String webAdTrack;
        private String date;
        private String promotion;
        private String label;
        private List<String> labelList;
        private String descriptionEditor;
        private String collected;
        private String played;
        private List<String> subtitles;
        private String lastViewTime;
        private String playlists;
        public void setDataType(String dataType) {
            this.dataType = dataType;
        }
        public String getDataType() {
            return dataType;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }
        public String getSlogan() {
            return slogan;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public String getDescription() {
            return description;
        }

        public void setProvider(Provider provider) {
            this.provider = provider;
        }
        public Provider getProvider() {
            return provider;
        }

        public void setCategory(String category) {
            this.category = category;
        }
        public String getCategory() {
            return category;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
        public Author getAuthor() {
            return author;
        }

        public void setCover(Cover cover) {
            this.cover = cover;
        }
        public Cover getCover() {
            return cover;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }
        public String getPlayUrl() {
            return playUrl;
        }

        public void setThumbPlayUrl(String thumbPlayUrl) {
            this.thumbPlayUrl = thumbPlayUrl;
        }
        public String getThumbPlayUrl() {
            return thumbPlayUrl;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
        public String getDuration() {
            return duration;
        }

        public void setWebUrl(WebUrl webUrl) {
            this.webUrl = webUrl;
        }
        public WebUrl getWebUrl() {
            return webUrl;
        }

        public void setReleaseTime(String releaseTime) {
            this.releaseTime = releaseTime;
        }
        public String getReleaseTime() {
            return releaseTime;
        }

        public void setLibrary(String library) {
            this.library = library;
        }
        public String getLibrary() {
            return library;
        }

        public void setPlayInfo(List<PlayInfo> playInfo) {
            this.playInfo = playInfo;
        }
        public List<PlayInfo> getPlayInfo() {
            return playInfo;
        }

        public void setConsumption(Consumption consumption) {
            this.consumption = consumption;
        }
        public Consumption getConsumption() {
            return consumption;
        }

        public void setCampaign(String campaign) {
            this.campaign = campaign;
        }
        public String getCampaign() {
            return campaign;
        }

        public void setWaterMarks(String waterMarks) {
            this.waterMarks = waterMarks;
        }
        public String getWaterMarks() {
            return waterMarks;
        }

        public void setAdTrack(String adTrack) {
            this.adTrack = adTrack;
        }
        public String getAdTrack() {
            return adTrack;
        }

        public void setTags(List<Tags> tags) {
            this.tags = tags;
        }
        public List<Tags> getTags() {
            return tags;
        }

        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setTitlePgc(String titlePgc) {
            this.titlePgc = titlePgc;
        }
        public String getTitlePgc() {
            return titlePgc;
        }

        public void setDescriptionPgc(String descriptionPgc) {
            this.descriptionPgc = descriptionPgc;
        }
        public String getDescriptionPgc() {
            return descriptionPgc;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
        public String getRemark() {
            return remark;
        }

        public void setIdx(String idx) {
            this.idx = idx;
        }
        public String getIdx() {
            return idx;
        }

        public void setShareAdTrack(String shareAdTrack) {
            this.shareAdTrack = shareAdTrack;
        }
        public String getShareAdTrack() {
            return shareAdTrack;
        }

        public void setFavoriteAdTrack(String favoriteAdTrack) {
            this.favoriteAdTrack = favoriteAdTrack;
        }
        public String getFavoriteAdTrack() {
            return favoriteAdTrack;
        }

        public void setWebAdTrack(String webAdTrack) {
            this.webAdTrack = webAdTrack;
        }
        public String getWebAdTrack() {
            return webAdTrack;
        }

        public void setDate(String date) {
            this.date = date;
        }
        public String getDate() {
            return date;
        }

        public void setPromotion(String promotion) {
            this.promotion = promotion;
        }
        public String getPromotion() {
            return promotion;
        }

        public void setLabel(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }

        public void setLabelList(List<String> labelList) {
            this.labelList = labelList;
        }
        public List<String> getLabelList() {
            return labelList;
        }

        public void setDescriptionEditor(String descriptionEditor) {
            this.descriptionEditor = descriptionEditor;
        }
        public String getDescriptionEditor() {
            return descriptionEditor;
        }

        public void setCollected(String collected) {
            this.collected = collected;
        }
        public String getCollected() {
            return collected;
        }

        public void setPlayed(String played) {
            this.played = played;
        }
        public String getPlayed() {
            return played;
        }

        public void setSubtitles(List<String> subtitles) {
            this.subtitles = subtitles;
        }
        public List<String> getSubtitles() {
            return subtitles;
        }

        public void setLastViewTime(String lastViewTime) {
            this.lastViewTime = lastViewTime;
        }
        public String getLastViewTime() {
            return lastViewTime;
        }

        public void setPlaylists(String playlists) {
            this.playlists = playlists;
        }
        public String getPlaylists() {
            return playlists;
        }

    }


    public static class ItemList {

        private String type;
        private Data data;
        private String tag;
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }

        public void setData(Data data) {
            this.data = data;
        }
        public Data getData() {
            return data;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }
        public String getTag() {
            return tag;
        }

    }

    public static class Tags {

        private int id;
        private String name;
        private String actionUrl;
        private String adTrack;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }
        public String getActionUrl() {
            return actionUrl;
        }

        public void setAdTrack(String adTrack) {
            this.adTrack = adTrack;
        }
        public String getAdTrack() {
            return adTrack;
        }

    }
}
