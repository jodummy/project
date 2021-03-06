<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>부트스트랩 틀</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- 스타일 -->
    <link href="../assets/css/bootstrap-ko.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 40px;
      }

      /* 전체 내용을 감쌈 */
      .container-narrow {
        margin: 0 auto;
        max-width: 700px;
      }
      .container-narrow > hr {
        margin: 30px 0;
      }

      /* 핵심 마케팅 문구와 가입 버튼 */
      .jumbotron {
        margin: 60px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 72px;
        line-height: 1;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* 부수적인 마케팅 내용 */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }
    </style>
    <link href="./" rel="stylesheet">
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- IE6~8에서 HTML5 태그를 지원하기위한 HTML5 shim -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- 파비콘과 앱 아이콘 -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="../assets/ico/favicon.png">
  </head>

  <body>

    <div class="container-narrow">

      <div class="masthead">
        <ul class="nav nav-pills pull-right">
          <li class="active"><a href="#">대문</a></li>
          <li><a href="#">소개</a></li>
          <li><a href="#">연락처</a></li>
        </ul>
        <h3 class="muted">프로젝트명</h3>
      </div>

      <hr>

      <div class="jumbotron">
        <h1>대단하고 어마어마한 마케팅 문구!</h1>
        <p class="lead">그리스의 천문학자. 알렉산드리아 도서관에서 일했으며, 세계에서 제일 먼저 지동설을 믿은 사람으로 전해지고 있다. 또한 기하학을 응용하여 태양이나 달의 크기를 처음으로 계산하였다.</p>
        <a class="btn btn-large btn-success" href="#">가입하세요</a>
      </div>

      <hr>

      <div class="row-fluid marketing">
        <div class="span6">
          <h4>부제목</h4>
          <p>운동을 할 수 있도록 쳇바퀴를 넣어 주는 것도 좋으며 케이지에 자동물병을 달아 준다.</p>

          <h4>부제목</h4>
          <p>햄스터는 작은 틈으로도 도망을 치기 때문에, 구멍이 작은 케이지를 준비한다. 바닥에는 신문지 따위를 깔고 이따금 갈아 넣어 준다.</p>

          <h4>부제목</h4>
          <p>서늘한 그늘에 놓아서 햇빛이 닿지 않고 바람이 잘 통하도록 해 준다.</p>
        </div>

        <div class="span6">
          <h4>부제목</h4>
          <p>운동을 할 수 있도록 쳇바퀴를 넣어 주는 것도 좋으며 케이지에 자동물병을 달아 준다.</p>

          <h4>부제목</h4>
          <p>햄스터는 작은 틈으로도 도망을 치기 때문에, 구멍이 작은 케이지를 준비한다. 바닥에는 신문지 따위를 깔고 이따금 갈아 넣어 준다.</p>

          <h4>부제목</h4>
          <p>서늘한 그늘에 놓아서 햇빛이 닿지 않고 바람이 잘 통하도록 해 준다.</p>
        </div>
      </div>

      <hr>

      <div class="footer">
        <p>&copy; 회사 2013</p>
      </div>

    </div> <!-- /container -->

    <!-- 자바스크립트
    ================================================== -->
    <!-- 페이지를 빨리 읽어들이도록 문서 마지막에 배치 -->
    <script src="../assets/js/jquery.js"></script>
    <script src="../assets/js/bootstrap-transition.js"></script>
    <script src="../assets/js/bootstrap-alert.js"></script>
    <script src="../assets/js/bootstrap-modal.js"></script>
    <script src="../assets/js/bootstrap-dropdown.js"></script>
    <script src="../assets/js/bootstrap-scrollspy.js"></script>
    <script src="../assets/js/bootstrap-tab.js"></script>
    <script src="../assets/js/bootstrap-tooltip.js"></script>
    <script src="../assets/js/bootstrap-popover.js"></script>
    <script src="../assets/js/bootstrap-button.js"></script>
    <script src="../assets/js/bootstrap-collapse.js"></script>
    <script src="../assets/js/bootstrap-carousel.js"></script>
    <script src="../assets/js/bootstrap-typeahead.js"></script>

  </body>
</html>
