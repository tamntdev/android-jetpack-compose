package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ImageScreen() {
    Column {
        // Load ảnh trên từ tài nguyên drawable
//        Image(
//            painter = painterResource(id = R.drawable.logo_android_studio), // Id của ảnh trong tài nguyên drawable
//            contentDescription = "Logo Android Studio", // Mô tả nội dung của ảnh để trợ giúp
//            contentScale = ContentScale.Crop // Chỉnh tỷ lệ hiển thị của ảnh
//        )
//        Image(
//            painter = painterResource(id = R.drawable.logo_xcode),
//            contentDescription = "Logo Xcode"
//        )
        // Ví dụ về scale ảnh, ta sử dụng tham số contentScale với các giá trị:
        //  - ContentScale.Fit: điều chỉnh ảnh cho vừa đường bao khung hiển thị, giữ nguyên tỉ lệ ảnh.
        //  - ContentScale.Crop: cắt ảnh ở chính giữa sao cho ảnh khớp với khung hiển thị.
        //  - ContentScale.FillHeight: điểu chỉnh ảnh sao cho chiều cao ảnh khớp với khung hiển
        //  thị ảnh. Có thể làm ảnh bị cắt theo chiều rộng nếu phải phóng to ảnh.
        //  - ContentScale.FillWidth: điều chỉnh ảnh sao cho chiều rộng khớp với khung hiển thị.
        //  Ảnh có thể bị cắt do chiều cao tăng lên/giảm xuống.
        //  - ContentScale.FillBounds: điều chỉnh ảnh ở cả chiều cao và rộng cho khớp với khung
        //  hiển thị của ảnh. Có thể làm méo ảnh do không giữ đúng tỉ lệ gốc ban đầu.
        //  - ContentScale.Inside: điều chỉnh ảnh vừa với đường bao của nơi chứa ảnh nếu
        //  ảnh lớn hơn khung chứa. Nếu ảnh nhỏ hơn khung chứa, không làm gì cả.
        //  - ContentScale.None: kích thước, tỉ lệ mặc định như ảnh nguyên gốc.

        // Load ảnh từ internet
        CoilImageExample("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKDXgebbqvpCrgBP1QqIHwEdLbAc6ooq7GJg&s")

        // Hiển thị icon
        Icon(
            imageVector = Icons.Rounded.Wallet,
            contentDescription = "Icon Wallet",
            tint = Color(0xFF01579B),
            modifier = Modifier.size(100.dp)
        )
    }
}

/**
 * Sử dụng thư viện Coil để load ảnh từ URL
 */
@Composable
fun CoilImageExample(imageUrl: String) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Sample image",
        // Các tùy chọn khác của AsyncImage
        // Ví dụ: contentScale, placeholder, error
        contentScale = ContentScale.Crop, // Chỉnh tỷ lệ hiển thị của ảnh
        placeholder = painterResource(id = R.drawable.logo_android_studio), // Hiển thị ảnh tạm thời
        error = painterResource(id = R.drawable.logo_xcode), // Hiển thị khi có lỗi
        modifier = Modifier
            .size(200.dp) // Điều chỉnh kích thước hiển thị
            .padding(16.dp)
            .clip(RoundedCornerShape(corner = CornerSize(20.dp)))
//            .clip(CircleShape) // Cắt ảnh thành hình tròn
    )
}

@Preview
@Composable
fun ImageScreenPreview() {
    ImageScreen()
}