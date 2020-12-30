// ◾◾◾◾ ORBIT DYNAMIC MENU ACTIVE LINK ◾◾◾◾
+function ($) {
  'use strict'

  //  ◾◾◾◾ Dynamic active menu ◾◾◾◾
  // Takes just the last method in Path Name
  //   var path = window.location.pathname.split("/").pop();
  // Get The Path From URL
  var path = window.location.pathname;
  //Treeview Select Home in case of ""
  if (path === "/") path = "/home";
  var target = $('.sidebar-menu li a[href="' + path + '"]');
  target.parent().addClass('active');
  $('.sidebar-menu li.active').parents('li').addClass('active');

}(jQuery) // End of use strict
// ◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾◾