package com.example.bloom_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.bloom_test.ui.theme.Bloom_TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bloom_TestTheme {
                MainScreen()
            }
        }
    }
}

val oswaldBold = FontFamily(
    Font(R.font.oswald_bold)
)

val lato_regular = FontFamily(
    Font(R.font.lato_regular)
)

@Composable
fun MainScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                listOf(
                    User("Charlie, 29", R.drawable.horse_rider, "ACTIVE FROM 5PM TO 11PM EST", "SURAT, INDIA"),
                )
            ) { user ->
                UserCardView(
                    userName = user.name,
                    imageResId = user.imageResId,
                    activeStatus = user.activeStatus,
                    location = user.location
                )
            }

            item {
                UserInformationCard(
                    title = "WHO AM I?",
                    attributes = listOf(
                        R.drawable.birthday_cake_svgrepo_com to "22",
                        R.drawable.measure_height_icon to "6'2 ft",
                        R.drawable.magnet_svgrepo_com to "Straight",
                        R.drawable.baseline_person_24 to "Male",
                        R.drawable.maps_pin_line_icon to "Surat,India",
                        R.drawable.work_case_svgrepo_com to "Android Developer",
                        R.drawable.education_svgrepo_com to "BCA",
                    ),
                    description = "I love exploring new places, trying out different cuisines, and spending time with animals."
                )
            }

            items(
                listOf(
                    User("", R.drawable.man, "", "")
                )
            ) { user ->
                UserCardView(
                    userName = user.name,
                    imageResId = user.imageResId,
                    activeStatus = user.activeStatus,
                    location = user.location
                )
            }

            item {
                CompatibilityCard()
            }

            item {
                UserInformationCard(
                    title = "WHAT I WANT?",
                    attributes = listOf(),
                    description = "❤\uFE0F Long Time Relationship"
                )
            }

            items(
                listOf(
                    User("", R.drawable.horse_rider2, "", "")
                )
            ) { user ->
                UserCardView(
                    userName = user.name,
                    imageResId = user.imageResId,
                    activeStatus = user.activeStatus,
                    location = user.location
                )
            }

            item {
                UserInformationCard(
                    title = "LIFESTYLE",
                    attributes = listOf(
                        R.drawable.wine_bottle_glass_icon to "Sometimes",
                        R.drawable.marijuana_icon to "Nope",
                        R.drawable.cigarette_smoking_icon to "Sometimes",
                        R.drawable.gym_svgrepo_com to "Exercise",
                        R.drawable.language_svgrepo_com to "English, Hindi, Gujarati",
                    ),
                    description = ""
                )
            }

            item {
                UserInformationCard(
                    title = "MY INTEREST",
                    attributes = listOf(
                        R.drawable.hiking_svgrepo_com to "Hiking",
                        R.drawable.travel_svgrepo_com to "Travelling",
                        R.drawable.swimming_svgrepo_com to "Swimming",
                        R.drawable.design_education_painting_svgrepo_com to "Fine Art",
                        R.drawable.stand_up_horse_with_jockey_svgrepo_com to "Horse Riding",
                        R.drawable.gamepad_svgrepo_com to "Gamer",
                    ),
                    description = ""
                )
            }

            items(
                listOf(
                    User("", R.drawable.horse_rider3, "", "")
                )
            ) { user ->
                UserCardView(
                    userName = user.name,
                    imageResId = user.imageResId,
                    activeStatus = user.activeStatus,
                    location = user.location
                )
            }

            item {
                ReportAndShareButtons()
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .zIndex(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircleButton(size = 50.dp, 0.4f, iconResId = R.drawable.cross)
            CircleButton(size = 70.dp, 0.8f, iconResId = R.drawable.staricon)
            CircleButton(size = 50.dp, 0.5f, iconResId = R.drawable.heart)
        }
    }
}



@Composable
fun UserCardView(userName: String?, imageResId: Int, activeStatus: String?, location: String?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    if (!userName.isNullOrEmpty()) {
                        Text(
                            text = userName,
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 43.sp,
                                fontFamily = oswaldBold
                            ),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }

                    if (!activeStatus.isNullOrEmpty()) {
                        InfoCard(text = activeStatus)
                    }

                    if (!location.isNullOrEmpty()) {
                        InfoCard(text = location)
                    }
                }
            }
        }
    }
}


@Composable
fun InfoCard(text: String) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, top = 5.dp)
            .height(25.dp)
            .wrapContentWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.4f))
    ) {
        Box(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 13.sp
                )
            )
        }
    }
}

@Composable
fun CircleButton(size: Dp, iconSize: Float,iconResId: Int) {
    Box(
        modifier = Modifier
            .size(size)
            .background(color = Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(size * iconSize),
            tint = Color.Unspecified
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserInformationCard(
    title: String,
    attributes: List<Pair<Int, String>>,
    description: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.light_grey)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), fontSize = 16.sp,
                fontFamily = oswaldBold,
                modifier = Modifier.padding(bottom = 12.dp, start = 3.dp)
            )

            if(attributes.isNotEmpty()){
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    attributes.forEach { attribute ->
                        AttributeItem(iconRes = attribute.first, label = attribute.second)
                    }
                }
            }

            if(description.isNotEmpty()){
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 22.sp),
                    fontFamily = lato_regular,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
fun AttributeItem(iconRes: Int, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(15.dp))
            .padding(horizontal = 14.dp, vertical = 6.dp)
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(end = 6.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall, fontSize = 12.sp, fontFamily = lato_regular
        )
    }
}

@Composable
fun CompatibilityCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = colorResource(id = R.color.light_grey))
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(contentAlignment = Alignment.Center) {
                Row(
                    modifier = Modifier.padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy((-20).dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.horse_rider),
                        contentDescription = "User Image 1",
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Image(
                        painter = painterResource(id = R.drawable.man),
                        contentDescription = "User Image 2",
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.White, CircleShape),
                        contentScale = ContentScale.Crop
                    )
                }

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(3.dp, Color(0xFF4CAF50), CircleShape),
                    contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "83%",
                        style = TextStyle(
                            color = Color(0xFF4CAF50),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Ethan and you are the perfect couple",
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = lato_regular,
                    color = Color.Black
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Based on your profiles, you are 83% compatible",
                style = TextStyle(
                    fontSize = 13.sp,
                    color = Color.Gray,
                    fontFamily = lato_regular
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ReportAndShareButtons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 100.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4F1F1),
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
        ) {
            Text(
                text = "Report or Block",
                style = TextStyle(
                    fontFamily = lato_regular,
                    fontSize = 13.sp
                )
            )
        }

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4F1F1),
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
        ) {
            Text(
                text = "Share Profile",
                style = TextStyle(
                    fontFamily = lato_regular,
                    fontSize = 13.sp
                )
            )
        }
    }
}


data class User(
    val name: String,
    val imageResId: Int,
    val activeStatus: String,
    val location: String
)
