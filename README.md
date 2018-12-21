# TransitionDrawable
Android Default TransitionDrawable enhancement to support more than 2 pictures <br>

Android 默认的TransitionDrawable 只能支持两张图片非常不爽，改写后支持多张图片，可以参考下算法，针对自己的项目适当修改。

![图片](https://github.com/JuneLeGency/TransitionDrawable/blob/master/example.gif)

#Usage 使用方法
Copy `TransitionDrawable.java` to your project<br>
add the following lines as initialized function
复制过去我的`TransitionDrawable.java` 文件
初始化构建TransitionDrawable 和timer 即可
```java
void init(){
  Drawable bg_0 = re.getDrawable(R.drawable.bg_0);
  ... more drawables
  welcome_background =new TransitionDrawable(bg_0,bg_1,bg_2,bg_3,bg_4,bg_5);
          
          timer = new Timer();
          task = new TimerTask() {
              public void run() {
                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          background_slide();
                      }
                  });
              }
          };
          
  //set the drawable to your view
  container.setBackground(welcome_background);
  //execute the timer
  timer.schedule(task, 5 * 1000, 5 * 1000);
}

//drawable run function
void background_slide(){
  welcome_background.startTransition(1000);
}
```
