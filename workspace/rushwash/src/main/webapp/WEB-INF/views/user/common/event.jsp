<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/rushwash/resources/css/user/template/event.css">
<!-- Add this to your head -->
<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

<body>
<!-- Add this before the closing </body> tag -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
            <img src="/rushwash/resources/img/user/event01.png" alt="Slide 1">
        </div>
        <div class="swiper-slide">
            <img src="/rushwash/resources/img/user/event01.png" alt="Slide 2">
        </div>
        <div class="swiper-slide">
            <img src="/rushwash/resources/img/user/event02.png" alt="Slide 3">
        </div>
        <div class="swiper-slide">
            <img src="/rushwash/resources/img/user/event01.png" alt="Slide 4">
        </div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Navigation -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
</div>

<script>
    // Initialize Swiper
    var swiper = new Swiper('.swiper-container', {
        slidesPerView: 1,
        spaceBetween: 10,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        loop: true, // 무한 루프
        autoplay: {
            delay: 5000, // 5초 간격으로 자동 슬라이드
        },
    });
</script>

</body>



