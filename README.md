<h1 align = center>Android Guide to Background Processing</h1> 
<p align = center>Simple Android example project to better understand Background Processes following diagram below<p>
<img src="https://developer.android.com/images/guide/background/task-category-tree.png" >

Background tasks fall into one of the following main categories:
<li>Immediate </li>
<li>Deferred </li>
<li>Exact </li>



<h3> Immediate </h3>
  <p>
  When needing a solution for tasks that have to be done immediately it is recommened by google that you use Kotlin Coroutines. 
  For more information on using coroutines check this link <a href = "https://developer.android.com/kotlin/coroutines">Kotlin coroutines</a>.
  </p>

<h3> Deferred </h3>
   <p>
   Any task that is not directly connected to a user interaction and can be run at any point in the future can use WorkManager.
   WorkManager makes it easy to schuedule deferrable tasks that expected to run even if the application exits or the device restarts. 
   Documentation for <a href="https://developer.android.com/topic/libraries/architecture/workmanager"> WorkManager</a> can be found here. 
   </p>


<h3> Exact </h3>
  <p>
  An exact task needs to be executed at an exact point in time. To achieve this you can use AlarManager.
  More information here on <a href = "https://developer.android.com/reference/android/app/AlarmManager">Alarm Manager</a> found here.
  </p>
