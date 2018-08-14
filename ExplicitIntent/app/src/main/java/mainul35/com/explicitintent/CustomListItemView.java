package mainul35.com.explicitintent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class CustomListItemView extends View {

    TextView tvStdName, tvStdAge, tvStdDept;

    public CustomListItemView(Context context, String stdName, String stdAge, String stdDept) {
        super(context);
        this.tvStdName = new TextView(context);
        this.tvStdAge = new TextView(context);
        this.tvStdDept = new TextView(context);

//        this.get
    }


}
