package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.DefaultMarqueeVelocity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Tương tự như Column trong Flutter
//                    Column {
//                        Greeting(
//                            name = "Android",
//                            modifier = Modifier.padding(innerPadding)
//                        )
//
//                        Greeting("Jetpack Compose",
//                            modifier = Modifier
////                                .fillMaxWidth() // Tương đương với Expanded trong Flutter
//                                .height(100.dp) // Set chiều cao cho Greeting
//                                .padding(12.dp) // Đặt padding cho Greeting
//                                .offset(x = (20).dp, y = (-20).dp) // Đặt vị trí của Greeting
//                                .background(color = Color(0xFF1174BF)) // Set màu nền cho Text
//                        )
//
//                        // Tương tự như Row trong Flutter
////                        Row(
////                            verticalAlignment = Alignment.CenterVertically, // Nội dung của Row căn giữa theo chiều dọc
////                            horizontalArrangement = Arrangement.End, // Nội dung của Row căn giữa theo chiều ngang
////                            modifier = Modifier.fillMaxSize() // Tương đương với Expanded trong Flutter
////                        ) {
////                            Image(
////                                painter = painterResource(id = R.drawable.ic_launcher_background),
////                                contentDescription = "Example image"
////                            )
////
////                            Greeting("Jetpack Compose")
////                        }
//
//                        ExampleRow(modifier = Modifier.padding(16.dp))
//
//                        // Tương tự Stack trong Flutter
////                        Box {
////                            Image(
////                                painter = painterResource(id = R.drawable.ic_android),
////                                contentDescription = "Example image"
////                            )
////                            Icon(Icons.Filled.Check, contentDescription = "Check mark")
////                        }
//                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
//                            .padding(20.dp)
                            .fillMaxSize()
                    ) {
//                        Greeting("Android Jetpack Compose!")
                        //                    CityScreen()
//                        MultiStyleText()
//                        BasicMarqueeSample(stringId = null)
//                        TextFieldScreen()
//                        ImageScreen()
//                        ResourcesInJetpackCompose()
//                        ScaffoldSample()
//                        SmallTopAppBarSample()
//                        CenterAlignTopAppBarSample()
//                        LargeTopAppBarSample()
//                        NavigationDrawerSample()
//                        FloatActionButtonSample()
//                        CardSample()
//                        DialogSample()
//                        RadioButtonAndCheckBoxSample()
//                        MyScreen()
//                        DropdownMenuWithDetails()
//                        SwitchMinimalExample()
//                        SwitchWithIconExample()
//                        PlainTooltipExample()
//                        RichTooltipExample()
//                        AdvancedRichTooltipExample()
//                        PullToRefreshBasicSampleView()
//                        ScaffoldWithSimpleSnackbar()
//                        ScaffoldWithCustomSnackbar()
//                        BadgeInteractiveExample()
//                        PartialBottomSheet()
                        HorizontalMultiBrowseCarouselSample()
                    }
                }
            }
        }
    }
}

/**
 * State management trong Compose
 *
 * - Để lưu trữ một đối tượng trong bộ nhớ từ trong các hàm composable, ta sử dụng remember API.
 * Một giá trị được tính toán bởi remember được lưu trữ trong Composition trong suốt quá trình khởi
 * tạo composition và giá trị được lưu trữ sẽ được trả về trong quá trình tái cấu trúc composition.
 *
 * - remember có thể được sử dụng để lưu trữ cả các đối tượng bất biến và các đối tượng có thể
 * thay đổi theo thời gian.
 *
 * - Chú ý rằng remember lưu trữ các đối tượng trong Composition và sẽ loại bỏ các đối tượng này
 * khi hàm composable đã gọi tới remember bị xóa khỏi Composition.
 *
 * - Sử dụng mutableStateOf để tạo lập các đối tượng có thể giám sát được(observable)
 * MutableState<T>, đây là một kiểu có thể giám sát được tích hợp tại runtime của Compose.
 *
 * - Bất kì thay đổi nào liên quan đến value sẽ khiến cho việc tái cấu trúc các hàm composable
 * đọc giá trị value được lên lịch để thực thi.
 *
 * - Có 3 cách để khai báo một đối tượng MutableState trong hàm composable:
 *              val mutableState = remember { mutableStateOf(default) }
 *              var value by remember { mutableStateOf(default) }
 *              val (value, setValue) = remember { mutableStateOf(default) }
 *
 * - Sau khi khai báo biến với remember, ta có thể sử dụng biến này làm tham số của các lời gọi tới
 * các hàm composable khác hoặc thậm chí có thể sử dụng như code logic để thay đổi những gì đang
 * hiển thị bởi các hàm composable.
 *
 * - Lưu ý rằng remember không hỗ trợ lưu trữ dữ liệu khi xảy ra thay đổi cấu hình,
 * ví dụ bạn xoay màn hình, đổi giao diện sáng tối…
 *
 * - Để không bị hiện tượng trên, bạn hãy sử dụng rememberSaveable
 *
 * - Các kiểu dữ liệu về trạng thái được hỗ trợ trong Compose
 * Compose không bắt buộc bạn phải sử dụng MutableState<T> để chứa các trạng thái.
 * Nó hỗ trợ sẵn các kiểu có thể giám sát khác. Vấn đề nằm ở chỗ bạn phải chuyển đổi các kiểu này
 * sang State<T> sau đó các hàm composable có thể tự động tái cấu trúc khi trạng thái thay đổi.
 *
 * - Flow: collectAsStateWithLifecycle(). collectAsStateWithLifecycle() thu thập các giá trị từ
 * Flow trong phương diện của một thành phần nhận biết vòng đời, cho phép ứng dụng của ta bảo toàn
 * tài nguyên. Nó thể hiện các giá trị mới nhất được gửi đi từ State của Compose. Sử dụng cách này
 * khi cần thu thập dữ liệu từ các flow trong Android app. Phương thức này chỉ sử dụng dành
 * riêng cho nền tảng Android.
 *
 * - Flow: collectAsState(). Tương tự như hàm bên trên. Sử dụng collectAsState() cho mã đa nền tảng.
 * Phương thức này đã có sẵn trong compose-runtime nên ta không cần bổ sung thêm dependency.
 *
 * - LiveData: observeAsState(). observeAsState() bắt đầu giám sát đối tượng LiveData và thể hiện các
 * giá trị thông qua State. Dependency: androidx.compose.runtime:runtime-livedata
 *
 * - RxJava2: subscribeAsState(). subscribeAsState() là một hàm mở rộng chuyển đổi RxJava2 stream
 * như Single, Observable, Completable sang Compose State. Dependency: androidx.compose.runtime:runtime-rxjava2
 *
 * - RxJava3: subscribeAsState(). Tương tự như tùy chọn bên trên nhưng áp dụng với RxJava3.
 * Dependency: androidx.compose.runtime:runtime-rxjava3
 *
 */
@Composable
fun GreetingContent(fullName: String, onChanged: (String) -> Unit, modifier: Modifier) {
    Column(modifier = modifier.padding(horizontal = 12.dp)) {
        Text(
            text = greet(fullName),
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        OutlinedTextField(
            value = fullName, // Giá trị hiện tại của trường nhập liệu
            label = { Text("Enter your name") }, // Hiển thị nhãn cho trường nhập liệu
            onValueChange = onChanged, // Gán giá trị mới cho fullName
            modifier = Modifier.fillMaxWidth() // Tương đương với Expanded trong Flutter
        )
    }
}

fun greet(name: String?): String {
    return if (name.isNullOrEmpty()) {
        "Hello, world!"
    } else {
        "Hello, $name!"
    }
}

/**
 * Chuyển đổi trạng thái
 *
 * Statefull vs stateless
 * - Bây giờ ta thấy xuất hiện khái niệm statefull và stateless:
 * - Statefull là các hàm composable có sử dụng remember để chứa các đối tượng tạo lập trạng thái
 * nội tại của composable. Tức là nó có chứa trạng thái. Ví dụ là đoạn code ở mục bên trên,
 * GreetingContent là một statefull composable. Các composable statefull hữu ích khi nơi gọi không
 * cần kiểm soát trạng thái và có thể sử dụng nó mà không cần quản lý trạng thái liên quan.
 * Tuy vậy, các composable với trạng thái nội tại như này ít có tính tái sử dụng và khó kiểm thử.
 * Như vậy ta cần một loại mới: stateless.
 * - Stateless là các hàm composable không chứa bất kì trạng thái nào.
 * Cách dễ nhất để đạt được stateless là sử dụng state hoisting – chuyển đổi trạng thái.
 * - State hoisting trong Compose là một mẫu chuyển trạng thái sang composable thực hiện lời gọi để
 * làm cho composable trở nên không trạng thái.
 * - Cách phổ biến để đạt được điều này trong Jetpack Compose là thay thế biến lưu trạng thái bởi hai tham số:
 *  + value: T: giá trị hiện thời cần hiển thị.
 *  + onValueChange: (T) -> Unit: một sự kiện yêu cầu giá trị value phải thay đổi trong đó
 *  T là giá trị mới được đề xuất
 */
@Composable
fun GreetingScreen() {
    //    var fullName by remember { mutableStateOf("") }
    var fullName by rememberSaveable { mutableStateOf("") }

    GreetingContent(fullName, onChanged = { fullName = it }, modifier = Modifier.padding(12.dp))
}

/**
 * Khôi phục trạng thái
 *
 * - Sử dụng tới rememberSaveable để đảm bảo trạng thái được lưu giữ ngay cả khi xảy ra quá trình
 * tái cấu trúc hoặc thay đổi cấu hình như khi ta xoay màn hình. Bản chất bên dưới của
 * rememberSaveable là sử dụng kĩ thuật save instance state.
 * - Lưu ý rằng rememberSaveable sẽ không lưu trạng thái của activity nếu activity bị hủy hoàn
 * toàn bởi người dùng như khi người dùng vuốt activity hiện thời từ dưới lên để đóng ứng
 * dụng trong màn hình các ứng dụng đã mở gần đây. Tất cả các kiểu dữ liệu được thêm vào Bundle đều
 * được lưu trữ một cách tự động. Do đó nếu ta muốn lưu gì đó mà không thể thêm vào bundle ta
 * có thể sử dụng một số cách sau:
 *
 * - Sử dụng Parcelize: giải pháp đơn giản nhất là bổ sung @Parcelize vào đối tượng.
 * Đối tượng này sau đó có thể chia nhỏ và bó lại với nhau.
 *
 * - Sử dụng MapSaver: nếu @Parcelize không phù hợp, ta có thể sử dụng mapSaver để định
 * nghĩa quy tắc riêng khi chuyển đổi đối tượng thành tập các giá trị mà hệ thống có thể lưu vào Bundle.
 *
 * - Sử dụng ListSaver: nếu không muốn định nghĩa các key, ta có thể sử dụng listSaver và
 * coi các vị trí phần tử là các keys:
 */
//val CitySaver = run {
//    val nameKey = "Name"
//    val countryKey = "Country"
//
//    mapSaver(
//        save = { mapOf(nameKey to it.name, countryKey to it.country) },
//        restore = { City(it[nameKey] as String, it[countryKey] as String) }
//    )
//}
//
//@Composable
//fun CityScreen() {
//    var selectedCity = rememberSaveable(stateSaver = CitySaver) {
//        mutableStateOf(City("Hanoi", "Vietnam"))
//    }
//}

// Sử dụng listSaver
val CitySaver = listSaver<City, Any>(
    save = { listOf(it.name, it.country) },
    restore = { City(it[0] as String, it[1] as String) }
)

@Composable
fun CityScreen() {
    var selectedCity = rememberSaveable(stateSaver = CitySaver) {
        mutableStateOf(City("Hanoi", "Vietnam"))
    }
}

/**
 *  Hàm composable là cấu trúc chính tạo lập và quản lý trạng thái của các phần tử giao diện trên màn hình.
 *
 *  Các modifier cho phép ta trang trí, gia cố(tăng cường) cho một composable.
 *  Nó làm một số nhiệm vụ như sau:
 * + Thay đổi kích thước, bố cục, hành vi, việc hiển thị của các composable(các phần tử giao diện
 * trong Compose framework gọi là composable).
 * + Bổ sung thông tin ví dụ như nhãn truy cập.
 * + Xử lý đầu vào từ người dùng.
 * + Bổ sung các tương tác bậc cao như làm cho một phần tử có thể nhấn vào được, kéo được,
 * cuộn được, thu phóng được.
 * + Modifiers là các đối tượng chuẩn trong Kotlin, ta tạo lập một modifier bằng cách gọi Modifier
 * đi kèm với các hàm có sẵn của nó.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier, // Áp dụng modifier đã được cung cấp
        maxLines = 2, // Set số dòng tối đa cho Text
        style = TextStyle(
            // Set các thuộc tính cho Text
            fontWeight = FontWeight.Bold, // Set font chữ đậm
            color = Color(0xFFFF9800), // Set màu chữ
            fontSize = 20.sp, // Set kích thước chữ
            fontFamily = FontFamily(Font(R.font.be_vietnam_pro_bold)), // Set font chữ đã custom
            textAlign = TextAlign.Center,
            lineHeight = 40.sp, // Set chiều cao chữ
            shadow = Shadow(
                color = Color(0xFF0277BD),
                offset = Offset(x = 5f, y = 10f),
                blurRadius = 3f
            )
        )
    )
}

// Multi style text tương tự như dùng RichText trong Flutter
@Composable
fun MultiStyleText() {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Blue)) {
                append("H")
            }
            append("ello ")
            withStyle(style = SpanStyle(color = Color.Red)) {
                append('W')
            }
            append("orld!")
        },
        fontSize = 36.sp
    )
}

// Sử dụng hiệu ứng marquee cho text
//@Composable
//@OptIn(ExperimentalFoundationApi::class)
//fun BasicMarqueeSample(stringId: Int?) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = stringId?.let { stringResource(id = it) } ?: "Hello Android Jetpack Compose!",
//            modifier = Modifier
//                .padding(24.dp)
//                .basicMarquee(
//                    velocity = DefaultMarqueeVelocity.times(3),
//                    iterations = Int.MAX_VALUE
//                ),
//            fontSize = 36.sp,
//            color = Color(0xFF01579B)
//        )
//    }
//}

@Composable
fun ExampleRow(modifier: Modifier) {
    Row(
        modifier = modifier
    ) {
        val localModifier = modifier
            .background(color = Color(0xFFE3F2FD))
        Text(
            modifier = localModifier.weight(2f),
            text = "Puppy",
            style = TextStyle(color = Color(0xFFFFAB00), fontSize = 32.sp)
        )
        Text(
            text = "Kitty",
            modifier = localModifier
                .background(color = Color(0xFFF57F17))
                .weight(1f),
            style = TextStyle(color = Color.White, fontSize = 32.sp)
        )
    }
}

/**
 * Button
 */
@Composable
fun FilledButtonSample(name: String, modifier: Modifier, onClick: (String) -> Unit) {
    var newName by rememberSaveable {
        mutableStateOf("")
    }
    Column(modifier = modifier) {
        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(top = 64.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        OutlinedTextField(
            value = newName,
            label = { Text("Enter your name") },
            onValueChange = { newName = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Button(
            onClick = {
                onClick(newName)
                newName = ""
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Submit")
        }

        OutlinedButton(
            onClick = {
                onClick(newName)
                newName = ""
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Enroll")
        }

        FilledTonalButton(
            onClick = {
                onClick(newName)
                newName = ""
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Accept")
        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "View More")
        }

        ElevatedButton(
            onClick = {
                onClick(newName)
                newName = ""
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Join Me")
        }
    }
}

/**
 * Xem trước: ta có thể gắn annotation @Preview trước một hàm composable để xem trước phần giao
 * diện của nó trên Android Studio mà không cần chạy ứng dụng lên.
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
//        Greeting("Android")

        var name by rememberSaveable {
            mutableStateOf("Someone")
        }
        val modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
        FilledButtonSample(name, modifier, onClick = { name = it })
    }
}