package br.com.alura.forum.entities.mapper

import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.view.TopicView
import org.springframework.stereotype.Component

@Component
class TopicMapper: Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
                id = t.id,
                title = t.title,
                message = t.message,
                createdIn = t.createdIn,
                status = t.status,
        )
    }
}