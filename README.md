# UtilCode
项目说明：Android常用的工具类。

## 依赖配置
- 方法一：

	Step 1. Add the JitPack repository to your build file

	Add it in your root build.gradle at the end of repositories:
	```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	```

	Step 2. Add the dependency
	```
	dependencies {
		compile 'com.github.Jeterlee:UtilCode:v1.0.0'
	}
	```

- 方法二：
	
	Step 1. Add the Maven repository to your build file
	
	Add it in your root build.gradle at the end of repositories:
	```
	allprojects {
		repositories {
			...
			maven { url "https://raw.githubusercontent.com/Jeterlee/MavenRepository/master" }
		}
	}
	```
	
	Step 2. Add the dependency
	```
	dependencies {
		compile 'cn.jeterlee:util:1.0.0'
	}
	```

## 优秀项目推荐
[**AndroidUtilCode**](https://github.com/Blankj/AndroidUtilCode)

## 参考资料

# License
```
Copyright (c) 2017, The Jeterlee authors 

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
