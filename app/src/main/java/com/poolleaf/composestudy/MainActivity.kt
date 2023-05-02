package com.poolleaf.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poolleaf.composestudy.model.HeroData
import com.poolleaf.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    val heroList = listOf(
        HeroData(
            name = "Red Lion Ranger",
            description = "Blazing Lion 블레이징 라이온(작열하는 사자) ",
            thumbnail = R.drawable.red
        ),
        HeroData(
            name = "Yellow Eagle Ranger",
            description = "Soaring Eagle 소어링 이글(비상하는 독수리)",
            thumbnail = R.drawable.yellow
        ),
        HeroData(
            name = "Blue Shark Ranger",
            description = "Surging Shark 서징 샤크(용솟음치는 상어)",
            thumbnail = R.drawable.blue
        ),
        HeroData(
            name = "Black Bison Ranger",
            description = "Iron Bison 아이언 바이슨(강철의 바이슨)",
            thumbnail = R.drawable.black
        ),
        HeroData(
            name = "White Tiger Ranger",
            description = "Noble Tiger 노블 타이거(고결한 호랑이)",
            thumbnail = R.drawable.white
        ),
        HeroData(
            name = "Princess Shayla",
            description = "슈라공주",
            thumbnail = R.drawable.princess
        ),
        HeroData(
            name = "Toxica",
            description = "듀크 오그이자, 마스터 오그의 부하. 한 번 쓰러진 오그를 부활시키는 역할을 담당하고 있다",
            thumbnail = R.drawable.villain
        ),
        HeroData(
            name = "Jindrax",
            description = "듀크 오그이자 마스터 오그의 부하.",
            thumbnail = R.drawable.villain2
        )
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                HeroList(heroList = heroList, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val heroList = listOf(
        HeroData(
            name = "Red Lion Ranger",
            description = "Blazing Lion 블레이징 라이온(작열하는 사자) ",
            thumbnail = R.drawable.red
        ),
        HeroData(
            name = "Yellow Eagle Ranger",
            description = "Soaring Eagle 소어링 이글(비상하는 독수리)",
            thumbnail = R.drawable.yellow
        ),
        HeroData(
            name = "Blue Shark Ranger",
            description = "Surging Shark 서징 샤크(용솟음치는 상어)",
            thumbnail = R.drawable.blue
        ),
        HeroData(
            name = "Black Bison Ranger",
            description = "Iron Bison 아이언 바이슨(강철의 바이슨)",
            thumbnail = R.drawable.black
        ),
        HeroData(
            name = "White Tiger Ranger",
            description = "Noble Tiger 노블 타이거(고결한 호랑이)",
            thumbnail = R.drawable.white
        ),
        HeroData(
            name = "Princess Shayla",
            description = "슈라공주",
            thumbnail = R.drawable.princess
        ),
        HeroData(
            name = "Toxica",
            description = "듀크 오그이자, 마스터 오그의 부하. 한 번 쓰러진 오그를 부활시키는 역할을 담당하고 있다",
            thumbnail = R.drawable.villain
        ),
        HeroData(
            name = "Jindrax",
            description = "듀크 오그이자 마스터 오그의 부하.",
            thumbnail = R.drawable.villain2
        )
    )
    ComposeStudyTheme {
        HeroList(
            heroList = heroList,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
