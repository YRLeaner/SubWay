package com.example.tyr.subway3.callback;

import com.example.tyr.subway3.R;
import com.kingja.loadsir.callback.Callback;



/**
 * Description:TODO
 * Create Time:2017/9/4 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */

public class LoadingCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_loading;
    }
}
