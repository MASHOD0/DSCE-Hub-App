package com.studios.amit.dsiofficial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amit Kumar on 13-08-2017.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>
{
    private Context context;
    private List<BookNotification> bookNotifications;

    public BookAdapter(List<BookNotification> messageNotifications, Context context){
        super();
        this.context = context;
        this.bookNotifications = messageNotifications;
    }

    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {

        BookNotification notification = bookNotifications.get(position);
        //String notificationMessageHint = notification.getNotificationTitle().substring(0, 25) + "...";
        holder.bookTitleTextView.setText(notification.getTitle());
        holder.bookSubjectTextView.setText(notification.getSubjet());
        holder.bookPriceTextView.setText(notification.getPrice());
        holder.bookAuthorTextView.setText(notification.getAuthor());
        holder.subject = bookNotifications.get(position).getSubjet();
        holder.name = bookNotifications.get(position).getSellerName();
        holder.phone = bookNotifications.get(position).getContactNumber();
        holder.email = bookNotifications.get(position).getSellerEmail();
    }

    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list, parent, false);
        return new BookAdapter.ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return bookNotifications.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView bookTitleTextView;
        private TextView bookSubjectTextView;
        private TextView bookAuthorTextView;
        private TextView bookPriceTextView;
        private String subject;
        private String name, email, phone;

        public ViewHolder(View view){
            super(view);
            bookTitleTextView = (TextView) view.findViewById(R.id.bookTitleTextView);
            bookAuthorTextView = (TextView) view.findViewById(R.id.bookAuthorTextView);
            bookPriceTextView = (TextView) view.findViewById(R.id.bookPriceTextView);
            bookSubjectTextView = (TextView) view.findViewById(R.id.bookSubjectTextView);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    //Log.i("ALERT !!", "View " + bookTitleTextView.getText() +" Clicked !!");
                    Intent intent = new Intent(context, BookInfoActivity.class);
                    if(name.equals(User.getUserName()))
                        intent.putExtra("MyBook", "true");
                    else
                        intent.putExtra("MyBook", "false");
                    intent.putExtra("Title", bookTitleTextView.getText());
                    intent.putExtra("Author", bookAuthorTextView.getText());
                    intent.putExtra("Price", bookPriceTextView.getText());
                    intent.putExtra("Edition", bookSubjectTextView.getText());
                    intent.putExtra("Subject", subject);
                    intent.putExtra("Name", name);
                    intent.putExtra("Phone", phone);
                    intent.putExtra("Email", email);
                    context.startActivity(intent);
                }
            });
        }
    }
}
