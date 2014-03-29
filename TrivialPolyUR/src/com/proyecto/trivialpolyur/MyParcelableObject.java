package com.proyecto.trivialpolyur;

import android.os.Parcel;
import android.os.Parcelable;
  
public class MyParcelableObject implements Parcelable{
  
    String name,website;
     
    Dado d;
    public Dado getDado() {
        return d;
    }
  
    public void setWebsite(Dado dado) {
        this.d = dado;
    }
    
     public MyParcelableObject(){
          d=new Dado();
    }
    
    
    private MyParcelableObject(Parcel in){
              this.name = in.readString();
              this.website = in.readString();
        }
      
    public String getWebsite() {
        return website;
    }
  
    public void setWebsite(String website) {
        this.website = website;
    }
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
  
    public int calculateLength() {
        return name.length() + website.length();
    }
 
    @Override
    public int describeContents() {
        return 0;
    }
  
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.website);
    }
      
    public static final MyParcelableObject.Creator<MyParcelableObject> CREATOR = new MyParcelableObject.Creator<MyParcelableObject>() {
        public MyParcelableObject createFromParcel(Parcel in) {
            return new MyParcelableObject(in);
        }
  
        public MyParcelableObject[] newArray(int size) {
            return new MyParcelableObject[size];
        }
    }; 
}
