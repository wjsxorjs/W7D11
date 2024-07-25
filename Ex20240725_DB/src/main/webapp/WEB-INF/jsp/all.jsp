<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원목록</title>
<style>
    #search{
        margin-bottom: 15px;
    }

    #t1{
        border: 1px solid black;
        border-collapse: collapse;
    }

    #t1 tbody{
        text-align: center;
    }

    #t1 th{
        border: 1px solid black;
        background-color: rgb(200, 200, 200);
        padding: 2px 10px;
    }

    #t1 td{
        border: 1px solid black;
        padding: 5px 10px;
    }
</style>
</head>
<body>
	<header>
        <h2>사원목록</h2>
    </header>
    <div id="search">
        <form action="search" method="post">
            <select name="searchType" id="searchType">
                <option value="1">사번</option>
                <option value="2">이름</option>
                <option value="3">직종</option>
                <option value="4">부서</option>
            </select>
            <input type="text" name="searchValue" id="searchValue"/>
            <button type="button" onclick="search()">검색[SUBMIT]</button>
            <button type="button" onclick="search_ajax()">검색[AJAX]</button>
        </form>
    </div>
    <table id="t1">
        <thead>
            <tr>
                <th>사번</th>
                <th>이름</th>
                <th>직종</th>
                <th>부서</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="evo" items="${e_ar}">
                <tr>
                    <td>${evo.empno}</td>
                    <td>${evo.ename}</td>
                    <td>${evo.job}</td>
                    <td>${evo.deptno}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script>
        function search(){
            let val = $("#searchValue").val().trim();
            if(val == '' || val.length < 1){
                alert("검색어를 입력하세요");
                $("#searchValue").val("");
                $("#searchValue").focus();
                return;
            }
            
            document.forms[0].submit();
            
        }
        
        function search_ajax(){
            let val = $("#searchValue").val().trim();
            if(val == '' || val.length < 1){
                alert("검색어를 입력하세요");
                $("#searchValue").val("");
                $("#searchValue").focus();
                return;
            }

            $.ajax({
                url: "search_ajax",
                method: "post",
                data:{
                    "searchType": $("#searchType").val(),
                    "searchValue": $("#searchValue").val(),
                },
                dataType: "json",
            }).done(function(data){
                console.log(data);
                let e_ar = data.e_ar;
                let str = "";
                for(let i=0;i<data.len;i++){
                    str += "<tr>";
                    str +=   "<td>";
                    str +=     e_ar[i].empno;
                    str +=   "</td>";
                    str +=   "<td>";
                    str +=     e_ar[i].ename;
                    str +=   "</td>";
                    str +=   "<td>";
                    str +=     e_ar[i].job;
                    str +=   "</td>";
                    str +=   "<td>";
                    str +=     e_ar[i].deptno;
                    str +=   "</td>";
                    str += "</tr>";
                }

                $("#t1 tbody").html(str);
            });

            
        }
    </script>
</body>
</html>