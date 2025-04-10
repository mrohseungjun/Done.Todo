package kr.co.project.doneai.ui.screen.HomeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.project.doneai.R
import kr.co.project.doneai.ui.component.BottomNavigationBar
import kr.co.project.doneai.ui.theme.DoneAiTheme

@Composable
fun HomeScreenRoot(){

}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        // 상단 타이틀
        Text(text = "Home AI", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))

        // 날짜와 인사
        Text(text = "Tuesday, April 23", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "Good morning!", fontSize = 18.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(24.dp))

        // 오늘의 할 일 박스
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Today's Tasks",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                val tasks = listOf(
                    "Finish report" to true,
                    "Go-for a run" to true,
                    "Read a book" to false,
                    "Buy groceries" to false
                )

                tasks.forEach { (task, completed) ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 6.dp)
                    ) {

                        if(completed){
                            Icon(
                                imageVector =  Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint =  Color(0xFF3A7BFE)
                            )
                        }else{
                            Icon(
                                painter =  painterResource(id = R.drawable.baseline_circle_24),
                                contentDescription = null,
                                tint =  Color.Gray
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = task, fontSize = 16.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 진행률 카드
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "90% of your tasks completed",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                LinearProgressIndicator(
                    progress = 0.9f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp),
                    color = Color(0xFF3A7BFE),
                    trackColor = Color(0xFFE0E0E0)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreView(){
    DoneAiTheme {
        HomeScreen()
    }
}
