package com.example.tyr.subway3.DownLoad;


import java.util.List;

/**
 * Created by tyr on 2017/4/22.
 */
public interface ThreadDao {
    public void insertThread(Threadinfo threadinfo);
    public void deleteThread(String url, int thread_id);
    public void updateThread(String url, int thread_id, long finished);

    public List<Threadinfo> getThreads(String url);
    public boolean isExists(String url, int thread_id);
}
