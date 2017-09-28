package com.example.tyr.subway3.beans;

import java.util.List;

/**
 * Created by tyr on 2017/8/21.
 */
public class MainFilmRoot {
    private Rating rating;
    private String reviews_count;
    private String wish_count;
    private String douban_site;
    private String year;
    private Images images;
    private String alt;
    private String id;
    private String mobile_url;
    private String title;
    private String do_count;
    private String share_url;
    private String seasons_count;
    private String schedule_url;
    private String episodes_count;
    private List<String> countries;
    private List<String> genres;
    private String collect_count;
    private List<Casts> casts;
    private String current_season;
    private String original_title;
    private String summary;
    private String subtype;
    private List<Directors> directors;
    private String comments_count;
    private String ratings_count;
    private List<String> aka;
    public void setRating(Rating rating) {
        this.rating = rating;
    }
    public Rating getRating() {
        return rating;
    }

    public void setReviews_count(String reviews_count) {
        this.reviews_count = reviews_count;
    }
    public String getReviews_count() {
        return reviews_count;
    }

    public void setWish_count(String wish_count) {
        this.wish_count = wish_count;
    }
    public String getWish_count() {
        return wish_count;
    }

    public void setDouban_site(String douban_site) {
        this.douban_site = douban_site;
    }
    public String getDouban_site() {
        return douban_site;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getYear() {
        return year;
    }

    public void setImages(Images images) {
        this.images = images;
    }
    public Images getImages() {
        return images;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
    public String getAlt() {
        return alt;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setMobile_url(String mobile_url) {
        this.mobile_url = mobile_url;
    }
    public String getMobile_url() {
        return mobile_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setDo_count(String do_count) {
        this.do_count = do_count;
    }
    public String getDo_count() {
        return do_count;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }
    public String getShare_url() {
        return share_url;
    }

    public void setSeasons_count(String seasons_count) {
        this.seasons_count = seasons_count;
    }
    public String getSeasons_count() {
        return seasons_count;
    }

    public void setSchedule_url(String schedule_url) {
        this.schedule_url = schedule_url;
    }
    public String getSchedule_url() {
        return schedule_url;
    }

    public void setEpisodes_count(String episodes_count) {
        this.episodes_count = episodes_count;
    }
    public String getEpisodes_count() {
        return episodes_count;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }
    public List<String> getCountries() {
        return countries;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public List<String> getGenres() {
        return genres;
    }

    public void setCollect_count(String collect_count) {
        this.collect_count = collect_count;
    }
    public String getCollect_count() {
        return collect_count;
    }

    public void setCasts(List<Casts> casts) {
        this.casts = casts;
    }
    public List<Casts> getCasts() {
        return casts;
    }

    public void setCurrent_season(String current_season) {
        this.current_season = current_season;
    }
    public String getCurrent_season() {
        return current_season;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }
    public String getOriginal_title() {
        return original_title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getSummary() {
        return summary;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
    public String getSubtype() {
        return subtype;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }
    public List<Directors> getDirectors() {
        return directors;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }
    public String getComments_count() {
        return comments_count;
    }

    public void setRatings_count(String ratings_count) {
        this.ratings_count = ratings_count;
    }
    public String getRatings_count() {
        return ratings_count;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }
    public List<String> getAka() {
        return aka;
    }


    public static class Rating {

        private String max;
        private String average;
        private String stars;
        private String min;
        public void setMax(String max) {
            this.max = max;
        }
        public String getMax() {
            return max;
        }

        public void setAverage(String average) {
            this.average = average;
        }
        public String getAverage() {
            return average;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }
        public String getStars() {
            return stars;
        }

        public void setMin(String min) {
            this.min = min;
        }
        public String getMin() {
            return min;
        }

    }


    public static class Images {

        private String small;
        private String large;
        private String medium;
        public void setSmall(String small) {
            this.small = small;
        }
        public String getSmall() {
            return small;
        }

        public void setLarge(String large) {
            this.large = large;
        }
        public String getLarge() {
            return large;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
        public String getMedium() {
            return medium;
        }

    }


    public static class Avatars {

        private String small;
        private String large;
        private String medium;
        public void setSmall(String small) {
            this.small = small;
        }
        public String getSmall() {
            return small;
        }

        public void setLarge(String large) {
            this.large = large;
        }
        public String getLarge() {
            return large;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
        public String getMedium() {
            return medium;
        }

    }

    public static class Casts {

        private String alt;
        private Avatars avatars;
        private String name;
        private String id;
        public void setAlt(String alt) {
            this.alt = alt;
        }
        public String getAlt() {
            return alt;
        }

        public void setAvatars(Avatars avatars) {
            this.avatars = avatars;
        }
        public Avatars getAvatars() {
            return avatars;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

    }


    public static class Directors {

        private String alt;
        private Avatars avatars;
        private String name;
        private String id;
        public void setAlt(String alt) {
            this.alt = alt;
        }
        public String getAlt() {
            return alt;
        }

        public void setAvatars(Avatars avatars) {
            this.avatars = avatars;
        }
        public Avatars getAvatars() {
            return avatars;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return id;
        }

    }
}
