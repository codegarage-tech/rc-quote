package com.reversecoder.quote.viewholder;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidviewhover.BlurLayout;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.reversecoder.library.bang.SmallBang;
import com.reversecoder.library.bang.SmallBangListener;
import com.reversecoder.quote.R;
import com.reversecoder.quote.activity.HomeActivity;
import com.reversecoder.quote.adapter.FavouriteAuthorDetailAdapter;
import com.reversecoder.quote.fragment.FavouriteFragmentNew;
import com.reversecoder.quote.model.Quote;
import com.reversecoder.quote.util.DataHandler;
import com.reversecoder.quote.util.FragmentUtilsManager;

/**
 * @author Md. Rashadul Alam
 *         Email: rashed.droid@gmail.com
 */
public class FavouriteQuoteViewHolder extends BaseViewHolder<Quote> {

    View parentView;

    TextView txtPersonName;
    BlurLayout blurLayout;
    View hover;

    Quote mQuote;
    FavouriteAuthorDetailAdapter mAdpater;
    int mPosition = -1;

    public FavouriteQuoteViewHolder(ViewGroup parent) {
        super(parent, R.layout.recyclerview_item_favourite_quote);

        parentView = $(R.id.root_layout);
        txtPersonName = $(R.id.tv_quote_name);
        blurLayout = $(R.id.blur_layout_favourite_quote);

//        hover = LayoutInflater.from(getContext()).inflate(R.layout.layout_hover_favourite_quote, null);
//        blurLayout.setHoverView(hover);
    }

    @Override
    public void setData(final Quote data) {

        mQuote = data;
        mAdpater = (FavouriteAuthorDetailAdapter) getOwnerAdapter();
        mPosition = mAdpater.getPosition(mQuote);

        txtPersonName.setText(data.getQuoteDescription());

        //Close hoverview of previous
//        if(!data.isHover()){
//            if (blurLayout.getHoverStatus() == BlurLayout.HOVER_STATUS.APPEARED) {
//                blurLayout.dismissHover();
//            }
//        }

//        blurLayout.setOnHoverStateChangeListener(new OnHoverStateChangeListener() {
//            @Override
//            public void onHoverStateChanged(boolean isHoverExist) {
//                if(isHoverExist){
//                    mAdpater.updateSelection(mQuote, isHoverExist);
//                }
//            }
//        });

//        hover.findViewById(R.id.iv_favourite).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                YoYo.with(Techniques.Tada)
////                        .duration(550)
////                        .playOn(view);
//
//                SmallBang smallBang = SmallBang.attach2Window(((HomeActivity) getContext()));
//                smallBang.bang(view, new SmallBangListener() {
//                    @Override
//                    public void onAnimationStart() {
//                        data.setFavourite(false);
//                        //update data into database
//                        new UpdateQuoteIntoDatabase(getContext().getApplicationContext(), data).execute();
//                    }
//
//                    @Override
//                    public void onAnimationEnd() {
//                        //Update removed data into adapter
//                        Quote updatedData = mAdpater.update(data, mPosition);
//                        Log.d("UpdatedQuote:", updatedData.toString());
//                        mAdpater.remove(mPosition);
//                        mAdpater.notifyDataSetChanged();
//                        if (mAdpater.getCount() == 0) {
//                            ((FavouriteFragmentNew) FragmentUtilsManager.getVisibleSupportFragment(((HomeActivity) getContext()), getContext().getString(R.string.ribble_menu_item_favourite))).onFragmentBackPressed();
//                        }
//                    }
//                });
//            }
//        });
    }

    class UpdateQuoteIntoDatabase extends AsyncTask<String, String, Quote> {

        private Context mContext;
        private Quote mQuote;

        UpdateQuoteIntoDatabase(Context context, Quote quote) {
            mContext = context;
            mQuote = quote;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Quote doInBackground(String... params) {
            Quote updatedDataIntoDatabase = DataHandler.setFavouriteForFavouriteFragment(mQuote, false);
            Log.d("updatedDataIntoDatabase", updatedDataIntoDatabase.toString());
            return updatedDataIntoDatabase;
        }

        @Override
        protected void onPostExecute(Quote result) {
        }
    }
}
