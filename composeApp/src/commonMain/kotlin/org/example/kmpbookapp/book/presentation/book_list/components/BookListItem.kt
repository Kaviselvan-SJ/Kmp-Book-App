package org.example.kmpbookapp.book.presentation.book_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.kmpbookapp.book.domain.Book
import org.example.kmpbookapp.core.presentation.LightBlue

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
            .clickable(onClick = onClick),
        color = LightBlue.copy(alpha = 0.2f)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ){
            Box(
                modifier = Modifier
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {

            }
        }
    }
}