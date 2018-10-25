package com.example.cy601.customlistdemo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DeleteDialog extends DialogFragment {
    private Button yesBtn, NoBtn;
    private String tag = "";
    // @Nullable
//    @Override
    //传统弹窗
//    public Dialog onCreateDialog(Bundle savedInstanceState){
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        // Get the layout inflater
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        View view = inflater.inflate(R.layout.delete_dialog, null);
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
//        builder.setView(view)
//                // Add action buttons
//                .setPositiveButton("YES",
//                        new DialogInterface.OnClickListener()
//                        {
//                            @Override
//                            public void onClick(DialogInterface dialog, int id)
//                            {
//
//                            }
//                        }).setNegativeButton("NO", null);
//        return builder.create();
//    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.delete_dialog, container);
        yesBtn = (Button) view.findViewById(R.id.yesBtn);
        NoBtn = (Button) view.findViewById(R.id.noBtn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取主界面传过来的 列表的位置
                int index = getArguments().getInt("deleteIndex");
//             //onClickCallback.onClick(view);
                tag = "yes";
                MainActivity activity = (MainActivity) getActivity();
                //调用主函数中的删除方法 对选中的item进行删除
                activity.onUserSelect(tag, index);

                //Toast.makeText("You had delete ",Toast.LENGTH_SHORT).show();
                //  Toast.makeText(, "你想提示的信息",Toast.LENGTH_SHORT).show();
                //按钮点击后 对话框消失
                DeleteDialog.this.dismiss();


            }
        });
        NoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //按钮点击后 对话框消失
                DeleteDialog.this.dismiss();

            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
