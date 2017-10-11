# QuicklyQueryContacts
联系人排序，快速查询,通过点击字母的方式快速到达联系人所在位置，支持拓展，各种实体类都可以进行排序和快速查询

效果图：

![querytest](https://github.com/CHAOHUILI/QuicklyQueryContacts/blob/master/querytest.gif "效果图")

使用方法：

在你projects的根目录的build.gradle中添加:

    allprojects {
      repositories {
          jcenter()
          maven { url "https://jitpack.io"}
      }
    }

然后在你moudule的build.gradle添加依赖:

	dependencies {
	      compile 'com.github.CHAOHUILI:QuicklyQueryContacts:v1.1.0'
	}
  
  具体使用（使用方法和此代码库中MainActivity方法相同，可下载参考！！！）：
  
  如果您是对实体类的数组进行排序和快速查询，则把您的实体类继承Friend类，并在实体类的构造方法中实现setName方法，传入的参数就是排序的依据（string类型）。
  例如我的Entity的构造方法如下：
  
    public Entity(String name) {
        setName(name);
    }

  当您使用开源库生成实体类的时候，是不会调用构造方法的，这时如果你想要把某个字段作为排序的依据，您需要把在这个字段的set方法中执行setName方法，参数传入就是这个字段。
  例如用我的Entity的nick作为排序依据，则可以这样写：
  
   public void setNick(String nick) {
        setName(nick);
        this.nick = nick;
    }
    
  生成数组后调用 
  
           Collections.sort(friendliest)
           
  方法，对你的数据进行排序，然后配置adapter，这里您也可以参照我的MyAdapter自己写一个适配器来满足您的需求。
  
  最后在页面的布局中找到QuickIndexBar，实现点击事件，进行快速查询，还可以对通过
  
        quickIndexBar.paint.setColor(getResources().getColor(R.color.colorAccent));
        quickIndexBar.paint.setTextSize(12);
        
 对导航栏字母的字体和颜色进行调整。
 
 您也可以下载module当做项目的库进行依赖，这样方便您根据自己的需求进行更改。
 
 如果使用中遇到什么问题，可以咨询：QQ664871385，如果帮到了您，记得star哦！
 
  
    
