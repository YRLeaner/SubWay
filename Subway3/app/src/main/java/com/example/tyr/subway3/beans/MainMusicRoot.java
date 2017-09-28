package com.example.tyr.subway3.beans;

import java.util.List;

/**
 * Created by tyr on 2017/8/22.
 */
public class MainMusicRoot {

    private int res;
    private Data data;
    public void setRes(int res) {
        this.res = res;
    }
    public int getRes() {
        return res;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }


    public class Author {

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


    public class Story_author {

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


    public class Author_list {

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


    public class Data {

        private String id;
        private String title;
        private String cover;
        private String isfirst;
        private String story_title;
        private String story;
        private String lyric;
        private String info;
        private String platform;
        private String music_id;
        private String charge_edt;
        private String related_to;
        private String web_url;
        private int praisenum;
        private String hide_flag;
        private String sort;
        private String maketime;
        private String last_update_date;
        private String read_num;
        private String story_summary;
        private String audio;
        private String anchor;
        private String editor_email;
        private String related_musics;
        private String album;
        private String start_video;
        private String media_type;
        private String copyright;
        private String audio_duration;
        private Author author;
        private Story_author story_author;
        private List<Author_list> author_list;
        private String feeds_cover;
        private String next_id;
        private String previous_id;
        private List<String> tag_list;

        private int sharenum;
        private int commentnum;
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

        public void setCover(String cover) {
            this.cover = cover;
        }
        public String getCover() {
            return cover;
        }

        public void setIsfirst(String isfirst) {
            this.isfirst = isfirst;
        }
        public String getIsfirst() {
            return isfirst;
        }

        public void setStory_title(String story_title) {
            this.story_title = story_title;
        }
        public String getStory_title() {
            return story_title;
        }

        public void setStory(String story) {
            this.story = story;
        }
        public String getStory() {
            return story;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
        public String getLyric() {
            return lyric;
        }

        public void setInfo(String info) {
            this.info = info;
        }
        public String getInfo() {
            return info;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }
        public String getPlatform() {
            return platform;
        }

        public void setMusic_id(String music_id) {
            this.music_id = music_id;
        }
        public String getMusic_id() {
            return music_id;
        }

        public void setCharge_edt(String charge_edt) {
            this.charge_edt = charge_edt;
        }
        public String getCharge_edt() {
            return charge_edt;
        }

        public void setRelated_to(String related_to) {
            this.related_to = related_to;
        }
        public String getRelated_to() {
            return related_to;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
        public String getWeb_url() {
            return web_url;
        }

        public void setPraisenum(int praisenum) {
            this.praisenum = praisenum;
        }
        public int getPraisenum() {
            return praisenum;
        }

        public void setHide_flag(String hide_flag) {
            this.hide_flag = hide_flag;
        }
        public String getHide_flag() {
            return hide_flag;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
        public String getSort() {
            return sort;
        }

        public void setMaketime(String maketime) {
            this.maketime = maketime;
        }
        public String getMaketime() {
            return maketime;
        }

        public void setLast_update_date(String last_update_date) {
            this.last_update_date = last_update_date;
        }
        public String getLast_update_date() {
            return last_update_date;
        }

        public void setRead_num(String read_num) {
            this.read_num = read_num;
        }
        public String getRead_num() {
            return read_num;
        }

        public void setStory_summary(String story_summary) {
            this.story_summary = story_summary;
        }
        public String getStory_summary() {
            return story_summary;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }
        public String getAudio() {
            return audio;
        }

        public void setAnchor(String anchor) {
            this.anchor = anchor;
        }
        public String getAnchor() {
            return anchor;
        }

        public void setEditor_email(String editor_email) {
            this.editor_email = editor_email;
        }
        public String getEditor_email() {
            return editor_email;
        }

        public void setRelated_musics(String related_musics) {
            this.related_musics = related_musics;
        }
        public String getRelated_musics() {
            return related_musics;
        }

        public void setAlbum(String album) {
            this.album = album;
        }
        public String getAlbum() {
            return album;
        }

        public void setStart_video(String start_video) {
            this.start_video = start_video;
        }
        public String getStart_video() {
            return start_video;
        }

        public void setMedia_type(String media_type) {
            this.media_type = media_type;
        }
        public String getMedia_type() {
            return media_type;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }
        public String getCopyright() {
            return copyright;
        }

        public void setAudio_duration(String audio_duration) {
            this.audio_duration = audio_duration;
        }
        public String getAudio_duration() {
            return audio_duration;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
        public Author getAuthor() {
            return author;
        }

        public void setStory_author(Story_author story_author) {
            this.story_author = story_author;
        }
        public Story_author getStory_author() {
            return story_author;
        }

        public void setAuthor_list(List<Author_list> author_list) {
            this.author_list = author_list;
        }
        public List<Author_list> getAuthor_list() {
            return author_list;
        }

        public void setFeeds_cover(String feeds_cover) {
            this.feeds_cover = feeds_cover;
        }
        public String getFeeds_cover() {
            return feeds_cover;
        }

        public void setNext_id(String next_id) {
            this.next_id = next_id;
        }
        public String getNext_id() {
            return next_id;
        }

        public void setPrevious_id(String previous_id) {
            this.previous_id = previous_id;
        }
        public String getPrevious_id() {
            return previous_id;
        }

        public void setTag_list(List<String> tag_list) {
            this.tag_list = tag_list;
        }
        public List<String> getTag_list() {
            return tag_list;
        }

        public void setSharenum(int sharenum) {
            this.sharenum = sharenum;
        }
        public int getSharenum() {
            return sharenum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }
        public int getCommentnum() {
            return commentnum;
        }

    }
}
