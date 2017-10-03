(function () {
    var mod = angular.module("myApp");
    mod.service("UserService", function ($http) {
      var self = this;
      self.getContacts = function () {
        var promise1 = $http.get('http://ec2-52-91-247-47.compute-1.amazonaws.com:8080/TekTimeSheet-1.0/interview/');
        var promise2 = promise1.then(function (response) {
          return response.data;
        });
        return promise2;
      };
  
    });
  
  })();