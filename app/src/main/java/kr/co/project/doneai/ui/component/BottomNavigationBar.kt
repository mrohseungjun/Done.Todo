package kr.co.project.doneai.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.project.doneai.R
import kr.co.project.doneai.ui.theme.DoneAiTheme

@Composable
fun BottomNavigationBar(currentRoute: String = "home", onNavigate: (String) -> Unit = {}) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentRoute == "home",
            onClick = { onNavigate("home") }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.DateRange, contentDescription = "Calendar") },
            label = { Text("Calendar") },
            selected = currentRoute == "calendar",
            onClick = { onNavigate("calendar") }
        )
        NavigationBarItem(
            icon = { Icon(painterResource(id = R.drawable.baseline_show_chart_24 ), contentDescription = "Stats") },
            label = { Text("Stats") },
            selected = currentRoute == "stats",
            onClick = { onNavigate("stats") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreView(){
    DoneAiTheme {
        BottomNavigationBar{
        }
    }
}