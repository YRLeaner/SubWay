package com.example.tyr.subway3.beans;

import java.util.List;

/**
 * Created by tyr on 2017/8/18.
 */
public class MusicRoot {

    private String res;
    private List<Data> data;
    public void setRes(String res) {
        this.res = res;
    }
    public String getRes() {
        return res;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
    public List<Data> getData() {
        return data;
    }

    public static class Author {

        private String user_id;
        private String user_name;
        private String desc;
        private String wb_name;
        private String is_settled;
        private String settled_type;
        private String summary;
        private String fans_total;
        private String web_url;
        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
        public String getUser_id() {
            return user_id;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }
        public String getUser_name() {
            return user_name;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }

        public void setWb_name(String wb_name) {
            this.wb_name = wb_name;
        }
        public String getWb_name() {
            return wb_name;
        }

        public void setIs_settled(String is_settled) {
            this.is_settled = is_settled;
        }
        public String getIs_settled() {
            return is_settled;
        }

        public void setSettled_type(String settled_type) {
            this.settled_type = settled_type;
        }
        public String getSettled_type() {
            return settled_type;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }
        public String getSummary() {
            return summary;
        }

        public void setFans_total(String fans_total) {
            this.fans_total = fans_total;
        }
        public String getFans_total() {
            return fans_total;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
        public String getWeb_url() {
            return web_url;
        }

    }


    public static class Share_info {

        private String url;
        private String image;
        private String title;
        private String content;
        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }

        public void setImage(String image) {
            this.image = image;
        }
        public String getImage() {
            return image;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setContent(String content) {
            this.content = content;
        }
        public String getContent() {
            return content;
        }

    }


    public static class Wx {

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }

        public void setLink(String link) {
            this.link = link;
        }
        public String getLink() {
            return link;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
        public String getImgUrl() {
            return imgUrl;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
        public String getAudio() {
            return audio;
        }

    }


    public static class Wx_timeline {

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }

        public void setLink(String link) {
            this.link = link;
        }
        public String getLink() {
            return link;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
        public String getImgUrl() {
            return imgUrl;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
        public String getAudio() {
            return audio;
        }

    }


    public static class Weibo {

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }

        public void setLink(String link) {
            this.link = link;
        }
        public String getLink() {
            return link;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
        public String getImgUrl() {
            return imgUrl;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
        public String getAudio() {
            return audio;
        }

    }


    public static class Qq {

        private String title;
        private String desc;
        private String link;
        private String imgUrl;
        private String audio;
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getDesc() {
            return desc;
        }

        public void setLink(String link) {
            this.link = link;
        }
        public String getLink() {
            return link;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
        public String getImgUrl() {
            return imgUrl;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
        public String getAudio() {
            return audio;
        }

    }


    public static class Share_list {

        private Wx wx;
        private Wx_timeline wx_timeline;
        private Weibo weibo;
        private Qq qq;
        public void setWx(Wx wx) {
            this.wx = wx;
        }
        public Wx getWx() {
            return wx;
        }

        public void setWx_timeline(Wx_timeline wx_timeline) {
            this.wx_timeline = wx_timeline;
        }
        public Wx_timeline getWx_timeline() {
            return wx_timeline;
        }

        public void setWeibo(Weibo weibo) {
            this.weibo = weibo;
        }
        public Weibo getWeibo() {
            return weibo;
        }

        public void setQq(Qq qq) {
            this.qq = qq;
        }
        public Qq getQq() {
            return qq;
        }

    }


    public static class Data {

        private String id;
        private String category;
        private String display_category;
        private String item_id;
        private String title;
        private String forward;
        private String img_url;
        private String like_count;
        private String post_date;
        private String last_update_date;
        private Author author;
        private String video_url;
        private String audio_url;
        private String audio_platform;
        private String start_video;
        private String has_reading;
        private String volume;
        private String pic_info;
        private String words_info;
        private String subtitle;
        private String number;
        private String serial_id;
        private List<String> serial_list;
        private String movie_story_id;
        private String ad_id;
        private String ad_type;
        private String ad_pvurl;
        private String ad_linkurl;
        private String ad_makettime;
        private String ad_closetime;
        private String ad_share_cnt;
        private String ad_pvurl_vendor;
        private String content_id;
        private String content_type;
        private String content_bgcolor;
        private String share_url;
        private Share_info share_info;
        private Share_list share_list;
        private List<String> tag_list;
        private String music_name;
        private String audio_author;
        private String audio_album;
        private String cover;
        private String bg_color;
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

        public void setCategory(String category) {
            this.category = category;
        }
        public String getCategory() {
            return category;
        }

        public void setDisplay_category(String display_category) {
            this.display_category = display_category;
        }
        public String getDisplay_category() {
            return display_category;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }
        public String getItem_id() {
            return item_id;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }
        public String getForward() {
            return forward;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }
        public String getImg_url() {
            return img_url;
        }

        public void setLike_count(String like_count) {
            this.like_count = like_count;
        }
        public String getLike_count() {
            return like_count;
        }

        public void setPost_date(String post_date) {
            this.post_date = post_date;
        }
        public String getPost_date() {
            return post_date;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }
        public String getLast_update_date() {
            return last_update_date;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
        public Author getAuthor() {
            return author;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }
        public String getVideo_url() {
            return video_url;
        }

        public void setAudio_url(String audio_url) {
            this.audio_url = audio_url;
        }
        public String getAudio_url() {
            return audio_url;
        }

        public void setAudio_platform(String audio_platform) {
            this.audio_platform = audio_platform;
        }
        public String getAudio_platform() {
            return audio_platform;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }
        public String getStart_video() {
            return start_video;
        }

        public void setHas_reading(String has_reading) {
            this.has_reading = has_reading;
        }
        public String getHas_reading() {
            return has_reading;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }
        public String getVolume() {
            return volume;
        }

        public void setPic_info(String pic_info) {
            this.pic_info = pic_info;
        }
        public String getPic_info() {
            return pic_info;
        }

        public void setWords_info(String words_info) {
            this.words_info = words_info;
        }
        public String getWords_info() {
            return words_info;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
        public String getSubtitle() {
            return subtitle;
        }

        public void setNumber(String number) {
            this.number = number;
        }
        public String getNumber() {
            return number;
        }

        public void setSerial_id(String serial_id) {
            this.serial_id = serial_id;
        }
        public String getSerial_id() {
            return serial_id;
        }

        public void setSerial_list(List<String> serial_list) {
            this.serial_list = serial_list;
        }
        public List<String> getSerial_list() {
            return serial_list;
        }

        public void setMovie_story_id(String movie_story_id) {
            this.movie_story_id = movie_story_id;
        }
        public String getMovie_story_id() {
            return movie_story_id;
        }

        public void setAd_id(String ad_id) {
            this.ad_id = ad_id;
        }
        public String getAd_id() {
            return ad_id;
        }

        public void setAd_type(String ad_type) {
            this.ad_type = ad_type;
        }
        public String getAd_type() {
            return ad_type;
        }

        public void setAd_pvurl(String ad_pvurl) {
            this.ad_pvurl = ad_pvurl;
        }
        public String getAd_pvurl() {
            return ad_pvurl;
        }

        public void setAd_linkurl(String ad_linkurl) {
            this.ad_linkurl = ad_linkurl;
        }
        public String getAd_linkurl() {
            return ad_linkurl;
        }

        public void setAd_makettime(String ad_makettime) {
            this.ad_makettime = ad_makettime;
        }
        public String getAd_makettime() {
            return ad_makettime;
        }

        public void setAd_closetime(String ad_closetime) {
            this.ad_closetime = ad_closetime;
        }
        public String getAd_closetime() {
            return ad_closetime;
        }

        public void setAd_share_cnt(String ad_share_cnt) {
            this.ad_share_cnt = ad_share_cnt;
        }
        public String getAd_share_cnt() {
            return ad_share_cnt;
        }

        public void setAd_pvurl_vendor(String ad_pvurl_vendor) {
            this.ad_pvurl_vendor = ad_pvurl_vendor;
        }
        public String getAd_pvurl_vendor() {
            return ad_pvurl_vendor;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }
        public String getContent_id() {
            return content_id;
        }

        public void setContent_type(String content_type) {
            this.content_type = content_type;
        }
        public String getContent_type() {
            return content_type;
        }

        public void setContent_bgcolor(String content_bgcolor) {
            this.content_bgcolor = content_bgcolor;
        }
        public String getContent_bgcolor() {
            return content_bgcolor;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }
        public String getShare_url() {
            return share_url;
        }

        public void setShare_info(Share_info share_info) {
            this.share_info = share_info;
        }
        public Share_info getShare_info() {
            return share_info;
        }

        public void setShare_list(Share_list share_list) {
            this.share_list = share_list;
        }
        public Share_list getShare_list() {
            return share_list;
        }

        public void setTag_list(List<String> tag_list) {
            this.tag_list = tag_list;
        }
        public List<String> getTag_list() {
            return tag_list;
        }

        public void setMusic_name(String music_name) {
            this.music_name = music_name;
        }
        public String getMusic_name() {
            return music_name;
        }

        public void setAudio_author(String audio_author) {
            this.audio_author = audio_author;
        }
        public String getAudio_author() {
            return audio_author;
        }

        public void setAudio_album(String audio_album) {
            this.audio_album = audio_album;
        }
        public String getAudio_album() {
            return audio_album;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }
        public String getCover() {
            return cover;
        }

        public void setBg_color(String bg_color) {
            this.bg_color = bg_color;
        }
        public String getBg_color() {
            return bg_color;
        }

    }
}
