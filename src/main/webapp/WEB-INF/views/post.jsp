<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" crossorigin="anonymous"></script><!--
-->     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.7/angular.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
            var rmApp = angular.module('rmApp', []);
            rmApp.controller('postCtrl', function($scope, $http) {
                var baseUrl = '/RickBookFinal/api/post';
                $scope.postList = [];
                function getItems() {
                    $http.get(baseUrl).then(
                        function(post){
                            $scope.postList = post.data;
                        },
                        function(error){
                            alert(error.message);
                        });
                }
                getItems();
                $scope.addItem = function() {
                    newPost = {
                        //postId: $scope.newPostId,
                        postContent: $scope.newPostContent//,
                        //timeOfPost: $scope.newTimeOfPost
                    };
                    $http.post(baseUrl, newPost).then(
                        function() {
                            // Timeout needed because updates happen too fast
                            setTimeout(getItems(), 500);
                        },
                        function(error){
                            alert(error.message);
                        }
                    );
                };
                
                $scope.editItem = function() {
                    editPostContent = {
                        postId: $scope.editPostId,
                        postContent: $scope.editPostContent,
                        postTimeStamp: $scope.editTimeStamp
                    };
                    $http.put(baseUrl + '/' + $scope.editPost, editPostContent).then(
                        function() {
                            setTimeout(getItems(), 500);
                        },
                        function(error){
                            alert(error.message);
                        }
                    );
                };
                
                $scope.delItem = function() {                    
                    $http.delete(baseUrl + '/' + $scope.delPost).then(
                        function() {
                            setTimeout(getItems(), 500);
                        },
                        function(error){
                            alert(error.message);
                        }
                    );
                };
            });
        </script>
</head>
<body>
<div class="jumbotron big-banner4" style="height:1000px; padding-top:150px;"> 
<div class="container">
        <div ng-app="rmApp" class="container">
            <div class="row" ng-controller="postCtrl">
                <div class="col-md-6">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Post Id</th>
                                <th>Post</th>
                                <th>Post Date</th>
                            </tr>
                        </thead>
                        <tbody id="post-table">
                            <tr ng-repeat="post in postList">
                                <td>{{ post.postId }}</td>
                                <td>{{ post.postContent }}</td>
                                <td>{{ post.timeOfPost }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <h1>New Post</h1>
                   
                    <div class="form-group">
                        <label>Content<input class="form-control" ng-model="newPostContent" /></label>
                    </div>
                    <button class="btn btn-success" ng-click="addItem()">Add</button>
                    
                    <h1>Edit Post</h1>
                    <div class="form-group">
                        <label>Post Id<input class="form-control" ng-model="editPostId" /></label>
                    </div>
                    <div class="form-group">
                        <label>Content<input class="form-control" ng-model="editPostContent" /></label>
                    </div>
                    <button class="btn btn-warning" ng-click="editItem()">Edit</button>
                    
                    <h1>Delete Post</h1>
                    <div class="form-group">
                        <label>Post Id<input class="form-control" ng-model="delPost" /></label>
                    </div>
                    <button class="btn btn-danger" ng-click="delItem()">Delete</button>

                </div>
            </div>
        </div>
    
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        
        <h2>Thanks ${pageContext.request.userPrincipal.name}  | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

</div>
    </div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
